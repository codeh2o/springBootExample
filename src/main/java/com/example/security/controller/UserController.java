package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-06 14:52
 **/
@RestController
public class UserController {

    /*
     * @Description: 获取用户信息方法1
     * @param
     * @return: java.lang.Object
     * @Author: h2o
     * @Date: 2020/7/8 1:05
     */
    @GetMapping("/")
    public Object info() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    /*
     * @Description: 获取用户信息方法2
     * @param
     * @return: java.lang.Object
     * @Author: h2o
     * @Date: 2020/7/8 1:05
     */
    @GetMapping("/info1")
    public Object info1(Authentication authentication) {
        return authentication;
    }
    /*
     * @Description: 获取用户信息的principal
     * @param
     * @return: java.lang.Object
     * @Author: h2o
     * @Date: 2020/7/8 1:05
     */
    @GetMapping("/info2")
    public Object info2(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }


}
