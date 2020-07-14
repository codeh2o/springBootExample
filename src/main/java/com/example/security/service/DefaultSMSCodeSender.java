package com.example.security.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 22:08
 **/
@Slf4j
public class DefaultSMSCodeSender implements SMSCodeSender {
    @Override
    public void send(String mobile, String code) {
      log.info("向"+mobile+"发送了验证码:"+code);
    }
}
