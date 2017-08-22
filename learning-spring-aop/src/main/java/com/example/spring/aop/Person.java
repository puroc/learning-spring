package com.example.spring.aop;

/**
 * Created by puroc on 2017/8/22.
 */
public class Person implements Worker {

    public void testBeforeAdvice(){
        System.out.println("testBeforeAdvice");
    }

    public void testAfterAdvice(){
        System.out.println("testAfter");
    }

    public void testAroundAdvice(){
        System.out.println("testAround");
    }

    public void testThrowsAdvice(){
        System.out.println("testThrowableAdvice");
        throw new RuntimeException("testThrowsAdvice exception");
    }


}
