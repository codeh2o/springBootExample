package com.example.security.configurations.validations;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 22:56
 **/
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
}
