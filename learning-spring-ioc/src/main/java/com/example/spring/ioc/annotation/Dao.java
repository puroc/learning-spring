package com.example.spring.ioc.annotation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by puroc on 2017/8/6.
 */
@Component
public class Dao implements InitializingBean {

    @PostConstruct
    public void init() {
        System.out.println("dao init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dao destroy");
    }

    private void update(){

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("dao afterPropertiesSet");
    }
}
