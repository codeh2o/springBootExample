package com.example.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-12 02:48
 **/
public class ValidateCodeException extends AuthenticationException {


    private static final long serialVersionUID = 2311292436235506657L;

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
