package com.example.spring.ioc.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by puroc on 2017/8/7.
 */
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor{


    /*
    spring内置的BeanFactoryPostProcessor
    org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
    org.springframework.beans.factory.config.PropertyOverrideConfigurer
    org.springframework.beans.factory.config.CustomEditorConfigurer
    */

    //在bean实例化之前,修改bean的定义
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final BeanDefinition teacher = beanFactory.getBeanDefinition("teacher");
        final MutablePropertyValues propertyValues = teacher.getPropertyValues();
        if(propertyValues.contains("name")){
            propertyValues.addPropertyValue("name","li");
        }
    }
}
