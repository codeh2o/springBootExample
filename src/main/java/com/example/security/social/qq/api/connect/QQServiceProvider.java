package com.example.security.social.qq.api.connect;

import com.example.security.social.qq.api.QQ;
import com.example.security.social.qq.api.QQimpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-22 23:13
 **/
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {
    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";//第一步将用户导向认证服务器
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token"; //第四步获取授权码

    public QQServiceProvider(String appId,String appSecret) {
        super(new OAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQimpl(accessToken,appId);
    }
}
