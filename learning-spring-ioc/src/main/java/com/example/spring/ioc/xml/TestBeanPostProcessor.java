package com.example.spring.ioc.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by puroc on 2017/8/9.
 */
public class TestBeanPostProcessor implements BeanPostProcessor {

    //bean实例化之后,调用初始化方法(init-method,或者是实现了InitializingBean接口的afterPropertiesSet方法之前)之前回调
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before:" + beanName + "实例化");
        return bean;
    }

    //bean实例化之后,调用初始化方法之前回调
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after:" + beanName + "实例化");
        return bean;
    }

}
