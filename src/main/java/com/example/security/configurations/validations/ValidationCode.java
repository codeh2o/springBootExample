package com.example.security.configurations.validations;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-09 13:04
 **/
@Getter
@Setter
public class ValidationCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidationCode(String code, int expireIn) {

        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidationCode(String code, LocalDateTime expireTime) {

        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
