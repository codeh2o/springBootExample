package com.example.security.configurations;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-12 13:11
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class ProjectProperties {

}
