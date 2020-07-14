package com.example.security.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-13 20:20
 **/
@Configuration
@ConfigurationProperties(prefix = "captcha")
@Getter
@Setter
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();
    private String URIs="";
}
