package com.example.security.configurations.validations.sms;

import com.example.security.configurations.validations.AbstractValidateCodeProcessor;
import com.example.security.configurations.validations.ValidateCodeProcessor;
import com.example.security.configurations.validations.ValidationCode;
import com.example.security.service.SMSCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-14 23:30
 **/
@Component
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidationCode> {
    @Autowired
    private SMSCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidationCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "mobile");
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
