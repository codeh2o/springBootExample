package com.example.security.social.qq.api.connect;

import com.example.security.social.qq.api.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-22 23:56
 **/
public class QQconnectionFactory extends OAuth2ConnectionFactory<QQ> {
    public QQconnectionFactory(String providerId,String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdaptor());
    }
}