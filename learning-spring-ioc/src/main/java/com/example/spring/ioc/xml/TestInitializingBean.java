package com.example.spring.ioc.xml;

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

    //bean的属性设置完毕后,回调该接口
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("属性设置完毕,a:" + a + ",b:" + b);
    }
}
