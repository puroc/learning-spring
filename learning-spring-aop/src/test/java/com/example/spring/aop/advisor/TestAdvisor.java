package com.example.spring.aop.advisor;

import com.example.spring.aop.domain.Worker;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by puroc on 2017/8/23.
 */
public class TestAdvisor {

    @Test
    public void testCommonAdvisor() throws Exception {
        try {
            String configPath = "beans2.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("testCommonAdvisor");
            //testBeforeAdvice是以test开头的方法,应该被切
            worker.testBeforeAdvice();
            //testAfterAdvice是以test开头的方法,应该被切
            worker.testAfterAdvice();
            //hello不是以test开头的方法,不应该被切
            worker.hello();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegexpAdvisor() throws Exception {
        try {
            String configPath = "beans2.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("testRegexpAdvisor");
            //testBeforeAdvice是以test开头的方法,应该被切
            worker.testBeforeAdvice();
            //testAfterAdvice是以test开头的方法,应该被切
            worker.testAfterAdvice();
            //hello不是以test开头的方法,不应该被切
            worker.hello();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDynamicAdvisor() throws Exception {
        try {
            String configPath = "beans2.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("testDynamicAdvisor");
            worker.say("hi");
            worker.say("haha");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
