package com.example.security.configurations;

import com.example.security.filter.ValidateCodeFilter;
import com.example.security.handler.AuthFailureHandler;
import com.example.security.handler.AuthSuccessHandler;
import com.example.security.mobile.SmsAuthenticationFilter;
import com.example.security.properties.validations.ValidateCodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-06 13:19
 **/
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${rememberMeSeconds}")
    private int rememberMeSeconds;

    @Autowired
    private ValidateCodeProperties validateCodeProperties;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private AuthFailureHandler authFailureHandler;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity HttpSecurity) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(authFailureHandler);
        validateCodeFilter.setValidateCodeProperties(validateCodeProperties);
        validateCodeFilter.afterPropertiesSet();


        SmsAuthenticationFilter smsAuthenticationFilter = new SmsAuthenticationFilter();
        smsAuthenticationFilter.setAuthenticationFailureHandler(authFailureHandler);
        smsAuthenticationFilter.afterPropertiesSet();

        HttpSecurity.addFilterBefore(smsAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .loginPage("/login.html")
                .loginProcessingUrl("/authentication/form")
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(rememberMeSeconds)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/login", "/login.html", "/loginWithSMS.html", "/code/image", "/code/sms", "/authentication/form", "/info2").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

}
