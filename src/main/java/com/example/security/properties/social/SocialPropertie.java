package com.example.security.properties.social;

import com.example.security.social.qq.api.QQPropertie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-23 10:29
 **/
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "social")
public class SocialPropertie {
    private QQPropertie qq = new QQPropertie();
}
