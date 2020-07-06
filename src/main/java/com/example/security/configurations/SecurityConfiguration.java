package com.example.security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-06 13:19
 **/
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity HttpSecurity) throws Exception {
        HttpSecurity.formLogin()
                .loginPage("/authentication/login")
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/login","/login.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

}
