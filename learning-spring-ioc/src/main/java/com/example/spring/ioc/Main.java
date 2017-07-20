package com.example.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by puroc on 17/7/20.
 */
public class Main {

    public static void main(String[] args) {
//        GenericApplicationContext context = new GenericApplicationContext();
//        new XmlBeanDefinitionReader(context).loadBeanDefinitions("application.xml");
//        context.refresh();

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    }
}
