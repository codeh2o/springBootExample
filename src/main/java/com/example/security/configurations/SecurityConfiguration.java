package com.example.security.configurations;

import com.example.security.filter.ValidateCodeFilter;
import com.example.security.handler.AuthFailureHandler;
import com.example.security.handler.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-06 13:19
 **/
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private AuthFailureHandler authFailureHandler;



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity HttpSecurity) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(authFailureHandler);

        validateCodeFilter.afterPropertiesSet();

        HttpSecurity.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .loginPage("/login.html")
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/login","/login.html","/code/image","/authentication/form").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

}
