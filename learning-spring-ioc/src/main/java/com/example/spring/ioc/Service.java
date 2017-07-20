package com.example.spring.ioc;

/**
 * Created by puroc on 17/7/20.
 */
public class Service {

    private Dao dao;

    public void printInfo(){
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(18);
        student.setSex("男");
        System.out.println(student);
    }


    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Dao getDao() {
        return dao;
    }
}
