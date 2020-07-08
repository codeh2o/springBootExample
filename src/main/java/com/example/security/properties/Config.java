package com.example.security.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-08 13:30
 **/
@Configuration
@EnableConfigurationProperties(BaseProperties.class)
public class Config {
}
