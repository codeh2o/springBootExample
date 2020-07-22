package com.example.security;

import com.example.security.configurations.validations.ValidateCodeGenerator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private Map<String,ValidateCodeGenerator> validateCodeGenerator;

    @Test
    void contextLoads() {

        String i = "hello %s,%s";
        String format = String.format(i, "world", "you");
        System.out.println(format);
    }

}
