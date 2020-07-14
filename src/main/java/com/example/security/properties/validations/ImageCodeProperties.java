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
public class ImageCodeProperties {
    private Integer width = 67;
    private Integer height = 23;
    private Integer length = 4;
    private Integer expired = 60;


}
