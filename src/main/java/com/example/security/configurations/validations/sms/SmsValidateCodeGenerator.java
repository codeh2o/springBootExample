package com.example.security.configurations.validations.sms;

import com.example.security.configurations.validations.ValidateCodeGenerator;
import com.example.security.configurations.validations.ValidationCode;
import com.example.security.configurations.validations.image.ImageCode;
import com.example.security.properties.validations.ValidateCodeProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 03:16
 **/
@Component("smsValidateCodeGenerator")
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private ValidateCodeProperties validateCodeProperties;

    @Override
    public ValidationCode generate(ServletWebRequest request) {
        String random = RandomStringUtils.randomNumeric(4);
        ValidationCode validationCode = new ValidationCode(random, 3600);
        return validationCode;
    }


}
