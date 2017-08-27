package com.example.spring.aop.advisor;

import com.example.spring.aop.domain.Worker;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

//自定义一个切面
public class CommonAdvisor extends StaticMethodMatcherPointcutAdvisor {

	//只在以test开头的方法中引入增加代码
	public boolean matches(Method method, Class clazz) {
		return method.getName().startsWith("test");
	}

	//只有Waiter的子类才引入增强代码
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class clazz){
				return Worker.class.isAssignableFrom(clazz);
			}
		};
	}
}
