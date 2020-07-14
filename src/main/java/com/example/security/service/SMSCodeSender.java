package com.example.security.service;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 22:07
 **/
public interface SMSCodeSender {
    void send(String mobile,String code);
}
