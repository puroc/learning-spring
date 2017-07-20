package com.example.spring.ioc;

/**
 * Created by puroc on 17/7/20.
 */
public class Service {

    public void printInfo(){
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(18);
        student.setSex("男");
        System.out.println(student);
    }


}
