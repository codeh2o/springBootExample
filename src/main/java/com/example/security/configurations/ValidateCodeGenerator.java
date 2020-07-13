package com.example.security.configurations;

import com.example.security.POJO.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 03:14
 **/
public interface ValidateCodeGenerator {
    ImageCode generate(ServletWebRequest request);
}
