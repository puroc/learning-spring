package com.example.spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by puroc on 2017/8/22.
 */
public class ThrowableAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target,
                              Exception ex) throws Throwable {
        System.out.println("method:" + method.getName()+",抛出异常:" + ex.getMessage());
    }
}
