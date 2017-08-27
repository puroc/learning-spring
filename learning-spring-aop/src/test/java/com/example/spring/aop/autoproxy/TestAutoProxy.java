package com.example.spring.aop.autoproxy;

import com.example.spring.aop.domain.Worker;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by puroc on 2017/8/27.
 */
public class TestAutoProxy {

    @Test
    public void testBeanNameAutoProxy() throws Exception {
        try {
            String configPath = "beans3.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
            Worker worker = (Worker)ctx.getBean("worker");
            worker.testAfterAdvice();
            worker.hello();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
