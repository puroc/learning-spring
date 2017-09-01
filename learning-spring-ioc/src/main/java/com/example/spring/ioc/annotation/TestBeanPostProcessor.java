package com.example.spring.ioc.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by puroc on 2017/8/9.
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

    /*
    spring内置的BeanPostProcessor
    org.springframework.context.annotation.CommonAnnotationBeanPostProcessor：支持@Resource注解的注入
    org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor：支持@Required注解的注入
    org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor：支持@Autowired注解的注入
    org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor：支持@PersistenceUnit和@PersistenceContext注解的注入
    org.springframework.context.support.ApplicationContextAwareProcessor：用来为bean注入ApplicationContext等容器对象
    */
    //bean实例化之后,调用初始化方法(init-method,或者是实现了InitializingBean接口的afterPropertiesSet方法之前)之前回调
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before:" + beanName + "实例化");
        return bean;
    }

    //bean实例化之后,调用初始化方法之后回调
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after:" + beanName + "实例化");
        return bean;
    }

}
