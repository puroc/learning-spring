package com.example.spring.tx.test;

import com.example.spring.tx.dao.PersonDao;
import com.example.spring.tx.domain.Person;
import com.example.spring.tx.service.PersonServiceA;
import com.example.spring.tx.service.PersonServiceB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.sql.SQLException;

/**
 * Created by puroc on 2017/8/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestTx {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonServiceA personServiceA;

    @Autowired
    private PersonServiceB personServiceB;

    @Test
    public void testPropagationRequiredJoinTx() {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithPropagationRequired(p1, p2);
//            personService.addPersonWithRuntimeException(p1, p2);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            Assert.isNull(personDao.getByName("zhangsan").getName());
        }
    }

//    @BeforeTransaction
//    public void before() {
//        System.out.println("before transaction----------------------------------");
//    }

    @Test
    public void testPropagationRequiredCreateTx() {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithPropagationRequired2(p1, p2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Assert.isTrue(personDao.countByName("zhangsan") == 1);
        }
    }

    @Test
    public void testPropagationNever() throws Exception {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        personServiceA.addPersonWithPropagationRequired3(p1,p2);
    }

    @Test
    public void testPropagationNever2() throws Exception {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithPropagationRequired4(p1,p2);
        } catch (IllegalTransactionStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPropagationSupports1() throws Exception {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithPropagationSupports1(p1,p2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Assert.isTrue(personDao.countByName("zhangsan") == 2);
        }
    }

    @Test
    public void testPropagationSupports2() throws Exception {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithPropagationSupports2(p1,p2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Assert.isNull(personDao.getByName("zhangsan").getName());
        }
    }

    @Test
    public void testPropagationMandatory() throws Exception {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPerson(p1,p2);
        } catch (IllegalTransactionStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void testPropagationRequiresNew() throws Exception {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            //这个方法将新启动一个事务
            personServiceA.addPersonWithPropagationRequiresNew(p1,p2);
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            Assert.isTrue(personDao.countByName("zhangsan") == 1);
        }
    }

    @Test
    public void testRollbackWithRuntimeException() {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithRuntimeException(p1, p2);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            Assert.isNull(personDao.getByName("zhangsan").getName());
        }
    }

    @Test
    public void testRollbackWithRuntimeException2() {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithRuntimeException2(p1, p2);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            Assert.isNull(personDao.getByName("zhangsan").getName());
        }
    }

    @Test
    public void testRollbackWithSQLException() {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithSqlException(p1, p2);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            Assert.isNull(personDao.getByName("zhangsan").getName());
        }
    }

    @Test
    public void testRollbackWithChildSQLException() {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        try {
            personServiceA.addPersonWithChildSQLException(p1, p2);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            Assert.isNull(personDao.getByName("zhangsan").getName());
        }
    }


}
