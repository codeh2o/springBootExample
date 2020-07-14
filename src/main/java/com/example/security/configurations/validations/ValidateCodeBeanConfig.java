package com.example.security.configurations.validations;

import com.example.security.configurations.validations.image.ImageValidateCodeGenerator;
import com.example.security.service.DefaultSMSCodeSender;
import com.example.security.service.SMSCodeSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 03:18
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageValidateCodeGenerator imageValidateCodeGenerator = new ImageValidateCodeGenerator();
        return imageValidateCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(name = "defaultSMSCodeSender")
    public SMSCodeSender defaultSMSCodeSender() {
       return  new DefaultSMSCodeSender();
    }
}
