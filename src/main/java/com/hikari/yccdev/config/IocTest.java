package com.hikari.yccdev.config;

import com.hikari.yccdev.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gang.xu01@hand-china.com on 2018/11/22
 */
public class IocTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = applicationContext.getBean(User.class);
        System.out.println(user.getName());
    }

}
