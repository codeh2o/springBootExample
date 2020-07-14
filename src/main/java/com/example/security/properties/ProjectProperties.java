package com.example.security.properties;

import com.example.security.properties.validations.ValidateCodeProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-12 13:11
 **/
@Configuration
@EnableConfigurationProperties(ValidateCodeProperties.class)
public class ProjectProperties {

}
