package com.example.spring.ioc.xml;

/**
 * Created by puroc on 17/7/20.
 */
public class Student {

    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "name:" + this.getName() + ",age:" + this.getAge() + ",sex:" + this.getSex();
    }
}
