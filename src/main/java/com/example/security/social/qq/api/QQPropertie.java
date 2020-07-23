package com.example.security.social.qq.api;

import lombok.Getter;
import lombok.Setter;


/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-23 10:24
 **/
@Getter
@Setter
public class QQPropertie {
    private String providerId = "qq";
    private String appId;
    private String appSecret;
}
