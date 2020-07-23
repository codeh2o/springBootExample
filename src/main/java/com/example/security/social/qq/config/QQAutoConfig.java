package com.example.security.social.qq.config;

import com.example.security.properties.social.SocialPropertie;
import com.example.security.social.qq.api.QQPropertie;
import com.example.security.social.qq.connect.QQconnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-23 10:48
 **/
@Configuration
public class QQAutoConfig extends SocialConfigurerAdapter {

    @Autowired
    private SocialPropertie socialPropertie;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer,
                                       Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }

    public ConnectionFactory<?> createConnectionFactory() {
        QQPropertie qq = socialPropertie.getQq();
        return new QQconnectionFactory(qq.getProviderId(),qq.getAppId(), qq.getAppSecret());
    }

    // 后补：做到处理注册逻辑的时候发现的一个bug：登录完成后，数据库没有数据，但是再次登录却不用注册了
    // 就怀疑是否是在内存中存储了。结果果然发现这里父类的内存ConnectionRepository覆盖了SocialConfig中配置的jdbcConnectionRepository
    // 这里需要返回null，否则会返回内存的 ConnectionRepository
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return null;
    }
}
