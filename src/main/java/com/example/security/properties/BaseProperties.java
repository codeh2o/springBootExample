package com.example.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-08 13:27
 **/

@ConfigurationProperties(prefix = "site")
@Getter
@Setter
public class BaseProperties {
    private Settings settings = new Settings();
    private String title;
}
