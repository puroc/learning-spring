package com.example.spring.aop.advice;

import com.example.spring.aop.domain.Dog;
import com.example.spring.aop.domain.Worker;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by puroc on 2017/8/22.
 */
public class TestAdvice {

    @Test
    public void testBefore() throws Exception {
        try {
            String configPath = "beans1.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("beforePerson");
            worker.testBeforeAdvice();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAfter() throws Exception {
        try {
            String configPath = "beans1.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("afterPerson");
            worker.testAfterAdvice();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAround() throws Exception {
        try {
            String configPath = "beans1.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("aroundPerson");
            worker.testAroundAdvice();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThrowable() throws Exception {
        try {
            String configPath = "beans1.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("throwablePerson");
            worker.testThrowsAdvice();
        } catch (Throwable e) {
//            e.printStackTrace();
        }
    }
    @Test
    public void testBeforeDog() throws Exception {
        try {
            String configPath = "beans1.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Dog dog = (Dog)ctx.getBean("beforeDog");
            dog.bark();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
