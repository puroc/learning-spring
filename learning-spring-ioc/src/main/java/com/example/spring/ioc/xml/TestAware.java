package com.example.spring.ioc.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestAware implements ApplicationContextAware, BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {

    private static ApplicationContext context = null;
    private ClassLoader classLoader;
    private BeanFactory beanFactory;
    private String name;


    //初始化当前这个bean时,在调用初始化方法(init-method,或者是实现了InitializingBean接口的afterPropertiesSet方法之前)之前,回调该方法
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
        System.out.println("ApplicationContextAware is ok");
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        System.out.println("BeanClassLoaderAware is ok");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("BeanFactoryAware is ok");
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("BeanNameAware is ok");
    }
}