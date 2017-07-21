package com.example.spring.ioc;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by puroc on 17/7/21.
 */
public class TestInitializingBean implements InitializingBean {

    private String a;

    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("属性设置完毕,a:" + a + ",b:" + b);
    }
}
