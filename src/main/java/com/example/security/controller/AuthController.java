package com.example.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-06 13:51
 **/
@Slf4j
@RestController
public class AuthController {
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/authentication/login")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String,String> requireAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse ) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest, httpServletResponse);


        String redirectUrl = savedRequest.getRedirectUrl();
        if(StringUtils.endsWithIgnoreCase(redirectUrl, ".html")){
            redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/login.html");
        }


        Map<String, String> result = new HashMap<>();
        result.put("msg","需要登陆");
        return result;

    }
}
