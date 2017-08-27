package com.example.spring.aop.domain;

/**
 * Created by puroc on 2017/8/22.
 */
public class Person implements Worker {

    @Override
    public void testBeforeAdvice(){
        System.out.println("testBeforeAdvice");
    }

    @Override
    public void testAfterAdvice(){
        System.out.println("testAfter");
    }

    @Override
    public void testAroundAdvice(){
        System.out.println("testAround");
    }

    @Override
    public void testThrowsAdvice(){
        System.out.println("testThrowableAdvice");
        throw new RuntimeException("testThrowsAdvice exception");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }

    @Override
    public void say(String word) {
        System.out.println("say " + word);
    }

}
