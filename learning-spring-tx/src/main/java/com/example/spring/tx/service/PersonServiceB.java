package com.example.spring.tx.service;

import com.example.spring.tx.dao.PersonDao;
import com.example.spring.tx.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by puroc on 2017/8/28.
 */
@Component
public class PersonServiceB {

    @Autowired
    private PersonDao personDao;

    //检查型异常（非运行时异常）,如需回滚,需要声明rollbackFor,且方法上必须声明throws SQLException,否则不会回滚
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
    public void addPersonWithPropagationRequired(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        this.addPersonFailedWithSQLException(p2);
    }
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = SQLException.class)
    public void addPersonWithPropagationSupports(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        this.addPersonFailedWithSQLException(p2);
    }

    public void addPersonFailedWithSQLException(Person person) throws SQLException {
        personDao.insertFailedWithSQLException(person);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void removePerson(Person person){
        System.out.println("remove11111111111");
    }

    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = SQLException.class)
    public void addPersonWithPropagationMandatory(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        this.addPersonFailedWithSQLException(p2);
    }


}
