package com.example.security.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-12 13:04
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    private Integer width = 67;
    private Integer height = 23;

}
