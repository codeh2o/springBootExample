package com.example.security.properties.validations;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-12 13:04
 **/
@Getter
@Setter
public class SmsCodeProperties {

    private Integer length = 4;
    private Integer expired = 60;
    private String URLs;


}
