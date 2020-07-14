package com.example.security;

import com.example.security.configurations.validations.ValidateCodeGenerator;
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

        System.out.printf(validateCodeGenerator.toString());
    }

}
