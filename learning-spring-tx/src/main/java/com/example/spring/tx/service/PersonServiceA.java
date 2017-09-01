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
public class PersonServiceA {

//    PROPAGATION_REQUIRED
//    如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择
//
//            PROPAGATION_SUPPORTS
//    支持当前事务，如果当前没有事务，就以非事务方式执行
//
//            PROPAGATION_MANDATORY
//    使用当前的事务，如果当前没有事务，就抛出异常
//
//            PROPAGATION_REQUIRES_NEW
//    新建事务，如果当前存在事务，把当前事务挂起
//
//            PROPAGATION_NOT_SUPPORTED
//    以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
//
//            PROPAGATION_NEVER
//    以非事务方式执行，如果当前存在事务，则抛出异常
//
//            PROPAGATION_NESTED
//    如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonServiceB personServiceB;

    //检查型异常（非运行时异常）,如需回滚,需要声明rollbackFor,且方法上必须声明throws SQLException,否则不会回滚
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
    public void addPersonWithPropagationRequired(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        personDao.insertFailedWithSQLException(p2);
    }

    public void addPersonWithPropagationRequired2(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        //这里如果是调用PersonServiceA的addPersonWithPropagationRequired方法的话,是不会回滚的,因为同一个类的内部方法调用,aop是不生效的,
        // 所以即使addPersonWithPropagationRequired添加了事务注解,也是不生效的
        personServiceB.addPersonWithPropagationRequired(p1, p2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addPersonWithPropagationRequired3(Person p1, Person p2) {
        personDao.insert(p1);
        //调用内部方法removePerson,虽然removePerson的事务传播属性是Propagation.NEVER,但因为是内部调用,所以removePerson的事务是失效的,
        // 这个方法的目的与addPersonWithPropagationRequired2一样,都是为了证明内部调用时,被调用方法的事务失效,只有当被调用方法是在其他类中,他的事务才生效
        this.removePerson(p2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addPersonWithPropagationRequired4(Person p1, Person p2) {
        personDao.insert(p1);
        //调用personServiceB的方法removePerson,因为removePerson的事务传播属性是Propagation.NEVER,同时本方法已经添加了事务控制,
        // 所以调用removePerson时会抛出异常,提示已经存在事务了
        personServiceB.removePerson(p2);
    }

    public void addPersonWithPropagationSupports1(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        //PersonServiceA的addPersonWithPropagationSupports没有事务控制,
        // 则personServiceB的addPersonWithPropagationSupports应该以非事务方式运行
        personServiceB.addPersonWithPropagationSupports(p1, p2);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
    public void addPersonWithPropagationSupports2(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        //PersonServiceA的addPersonWithPropagationSupports有事务控制,
        // 则personServiceB的addPersonWithPropagationSupports应该以事务方式运行
        personServiceB.addPersonWithPropagationSupports(p1, p2);
    }

    //运行时异常,不需要声明rollbackFor,自动回滚
    @Transactional(propagation = Propagation.REQUIRED)
    public void addPersonWithRuntimeException(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        personDao.insertFailedWithRuntimeException(p2);
    }

    //即使声明rollbackFor = SQLException.class,运行时异常也会触发回滚
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
    public void addPersonWithRuntimeException2(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        personDao.insertFailedWithRuntimeException(p2);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
    public void addPersonWithSqlException(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        personDao.insertFailedWithSQLException(p2);
    }

    //声明rollbackFor = SQLException.class,实际抛出的是SQLException的子类,也是可以回滚的
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
    public void addPersonWithChildSQLException(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        personDao.insertFailedWithChildSQLException(p2);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void removePerson(Person person) {
        System.out.println("i don't want to remove anyone");
    }

    public void addPerson(Person p1, Person p2) throws SQLException {
        //因为personServiceA的addPerson方法没有事务控制,所以调用personServiceB.addPersonWithPropagationMandatory方法时,会抛出异常,
        // 因为他是Propagation.MANDATORY
        personServiceB.addPersonWithPropagationMandatory(p1, p2);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPersonWithPropagationRequiresNew(Person p1, Person p2) throws SQLException {
        personDao.insert(p1);
        personDao.insert(p2);
    }

}
