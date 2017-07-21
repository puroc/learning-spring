package com.example.spring.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by puroc on 17/7/20.
 */
public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //对于非web环境的spring容器,只有注册hook之后,bean的destroy方法才能被调用
        context.registerShutdownHook();

    }
}
