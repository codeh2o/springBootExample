package com.example.security.controller;

import com.example.security.properties.BaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-06 14:52
 **/
@RestController
public class UserController {

    @Autowired
    private BaseProperties baseProperties;

    @GetMapping("/")
    public String info() {
     String baseURL = baseProperties.getKeywords();
     return baseURL;
    }





}
