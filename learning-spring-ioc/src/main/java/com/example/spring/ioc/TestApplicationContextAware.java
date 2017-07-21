package com.example.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestApplicationContextAware implements ApplicationContextAware {

    private static ApplicationContext context = null;
  
    @Override  
    public void setApplicationContext(ApplicationContext applicationContext)  
            throws BeansException {
        context = applicationContext;
        System.out.println("ApplicationContextAware is ok");
    }  
      
    public static Object getBean(String name){  
        return context.getBean(name);  
    }  
      
} 