package com.example.spring.aop.domain;

/**
 * Created by puroc on 2017/8/22.
 */
public interface Worker {

    void testBeforeAdvice();

    void testAfterAdvice();

    void testAroundAdvice();

    void testThrowsAdvice();

    void hello();

    void say(String word);
}
