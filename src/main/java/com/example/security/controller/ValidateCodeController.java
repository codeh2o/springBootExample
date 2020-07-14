package com.example.security.controller;

import com.example.security.configurations.validations.ValidateCodeProcessor;
import com.example.security.configurations.validations.ValidationCode;
import com.example.security.configurations.validations.image.ImageCode;
import com.example.security.configurations.validations.ValidateCodeGenerator;
import com.example.security.service.SMSCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @program: security
 * @description: 图形验证码
 * @author: yetin
 * @create: 2020-07-09 11:54
 **/
@Controller
public class ValidateCodeController {


    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     * @param request
     * @param response
     * @param type
     * @throws Exception
     */
    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        ValidateCodeProcessor validateCodeProcessor = validateCodeProcessors.get(type + "CodeProcessor");
        validateCodeProcessor.create(new ServletWebRequest(request, response));;


    }





}
