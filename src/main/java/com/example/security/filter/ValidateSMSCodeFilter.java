package com.example.security.filter;

import com.example.security.ValidateCodeException;
import com.example.security.configurations.validations.ValidateCodeProcessor;
import com.example.security.configurations.validations.ValidationCode;
import com.example.security.configurations.validations.image.ImageCode;
import com.example.security.properties.validations.ValidateCodeProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-09 13:27
 **/
@Getter
@Setter
@Slf4j
public class ValidateSMSCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private ValidateCodeProperties validateCodeProperties;

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private Set<String> urls = new HashSet<>();

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        String[] configURLs = StringUtils.splitByWholeSeparatorPreserveAllTokens(validateCodeProperties.getURIs(),",");
        for (String configURL:configURLs
             ) {
            urls.add(configURL);
        }
        urls.add("/authentication/mobile");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        boolean action = false;
        for (String url : urls) {
            if(pathMatcher.match(url, request.getRequestURI())){
                action = true;
            }
        }

        if(action){
            try{
                validate(new ServletWebRequest(request));
            }catch (ValidateCodeException e) {
                log.info(String.valueOf(e));
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }

        }
        filterChain.doFilter(request,response);
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {

        ValidationCode codeInSession = (ValidationCode) sessionStrategy.getAttribute(request,
                ValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");



        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "smsCode");

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if(codeInSession == null){
            throw new ValidateCodeException("验证码不存在");
        }

        if(codeInSession.isExpired()){
            sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");
            throw new ValidateCodeException("验证码已过期");
        }

        if(!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }

        sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");
    }


}
