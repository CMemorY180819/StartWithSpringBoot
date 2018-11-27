package com.hikari.yccdev.config;

import com.hikari.yccdev.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by gang.xu01@hand-china.com on 2018/11/22
 */
@Configuration
public class AppConfig {

    @Bean(name = "hikari")
    public User initUser(){
        User user = new User();
        user.setId(1);
        user.setName("hikari");
        return user;
    }

    //注入restApi的操作类
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);
        factory.setReadTimeout(5000);
        return factory;
    }

}
