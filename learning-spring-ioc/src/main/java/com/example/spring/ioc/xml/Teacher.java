package com.example.spring.ioc.xml;

/**
 * Created by puroc on 2017/8/7.
 */
public class Teacher  {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init(){
        System.out.println("teacher name:" + this.getName());
    }
}
