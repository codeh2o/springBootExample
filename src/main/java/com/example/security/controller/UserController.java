package com.example.security.controller;

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

    @GetMapping("/user")
    public Map<String, String> info() {
        HashMap<String, String> userHashMap = new HashMap<>();
        userHashMap.put("username", "hello");
        return userHashMap;

    }
}
