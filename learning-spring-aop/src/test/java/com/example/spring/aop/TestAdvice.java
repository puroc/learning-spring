package com.example.spring.aop;

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
            Worker worker = (Worker)ctx.getBean("before");
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
            Worker worker = (Worker)ctx.getBean("after");
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
            Worker worker = (Worker)ctx.getBean("around");
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
            Worker worker = (Worker)ctx.getBean("throwable");
            worker.testThrowsAdvice();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
