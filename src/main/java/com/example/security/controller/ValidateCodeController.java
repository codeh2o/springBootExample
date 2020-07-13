package com.example.security.controller;

import com.example.security.POJO.ImageCode;
import com.example.security.configurations.ImageCodeProperties;
import com.example.security.configurations.ValidateCodeGenerator;
import com.example.security.configurations.ValidateCodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: security
 * @description: 图形验证码
 * @author: yetin
 * @create: 2020-07-09 11:54
 **/
@Controller
public class ValidateCodeController {


    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    //private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = imageCodeGenerator.generate(new ServletWebRequest(request));
        httpSession.setAttribute(SESSION_KEY,imageCode);
        response.setHeader("content-type", "image/jpeg");
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());

    }






}
