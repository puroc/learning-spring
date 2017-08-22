package com.example.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by puroc on 2017/8/22.
 */
public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("around advice before method");
        final Object obj = invocation.proceed();
        System.out.println("around advice after method");
        return obj;
    }
}
