package com.example.security.social.qq.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @program: security
 * @description:获得openId并且获取用户信息
 * @author: h2o
 * @create: 2020-07-22 22:18
 **/
public class QQimpl extends AbstractOAuth2ApiBinding implements QQ {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;
    private String openId;

    public QQimpl(String accessToken,  String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER); //accessToken放在url里
        this.appId = appId;
        String url = String.format(URL_GET_OPENID,accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        this.openId = StringUtils.substringBetween(result, "openid\":\"", "\"}");

    }

    @Override
    public QQUserInfo getUserInfo() {
        String url = String.format(URL_GET_USERINFO,appId,openId);
        String result = getRestTemplate().getForObject(url,String.class);
        QQUserInfo qqUserInfo = null;
        try {
            qqUserInfo = objectMapper.readValue(result, QQUserInfo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return qqUserInfo;
    }
}
