package com.example.security.filter;

import com.example.security.POJO.ImageCode;
import com.example.security.controller.ValidateCodeController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-09 13:27
 **/
public class ValidateCodeFilter extends OncePerRequestFilter {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getRequestURI());
        if(StringUtils.equals("/authentication/form",request.getRequestURI())){
            validate(new ServletWebRequest(request));
        }
        filterChain.doFilter(request,response);
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {

        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request,
                ValidateCodeController.SESSION_KEY);

        System.out.println(codeInSession.getCode());

//        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
//
//        if (StringUtils.isBlank(codeInRequest)) {
//            throw new ValidateCodeException("验证码的值不能为空");
//        }
//
//        if(codeInSession == null){
//            throw new ValidateCodeException("验证码不存在");
//        }
//
//        if(codeInSession.isExpried()){
//            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
//            throw new ValidateCodeException("验证码已过期");
//        }
//
//        if(!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
//            throw new ValidateCodeException("验证码不匹配");
//        }
//
//        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
    }
}
