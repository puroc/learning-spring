package com.example.spring.aop;

/**
 * Created by puroc on 2017/8/22.
 */
public interface Worker {

    void testBeforeAdvice();

    void testAfterAdvice();

    void testAroundAdvice();

    void testThrowsAdvice();
}
