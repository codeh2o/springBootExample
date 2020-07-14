package com.example.security.configurations.validations;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 03:14
 **/
public interface ValidateCodeGenerator {
    ValidationCode generate(ServletWebRequest request);
}
