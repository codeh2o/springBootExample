package com.example.security.social.qq.connect;

import com.example.security.social.qq.api.QQ;
import com.example.security.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @program: security
 * @description:
 * @author: h2o
 * @create: 2020-07-22 23:33
 **/
public class QQAdaptor implements ApiAdapter<QQ> {
    @Override
    public boolean test(QQ qq) { //测试API是否可用
        return true;
    }

    @Override
    public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {
        QQUserInfo qqUserInfo = qq.getUserInfo();
        connectionValues.setDisplayName(qqUserInfo.getNickname());
        connectionValues.setImageUrl(qqUserInfo.getFigureurl_1());
        connectionValues.setProfileUrl("");
        connectionValues.setProviderUserId(qqUserInfo.getOpenId());

    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
