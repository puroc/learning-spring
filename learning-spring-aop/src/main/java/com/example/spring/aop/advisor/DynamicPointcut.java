package com.example.spring.aop.advisor;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class DynamicPointcut extends DynamicMethodMatcherPointcut {

	public boolean matches(Method method, Class clazz, Object[] args) {
		if(method.getName().startsWith("say")){
           String word = (String) args[0];
			return "hi".equalsIgnoreCase(word);
		}
		return false;
	}

}
