package com.example.spring.tx.test;

import com.example.spring.tx.dao.PersonDao;
import com.example.spring.tx.domain.Person;
import com.example.spring.tx.service.PersonServiceA;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * Created by puroc on 2017/9/4.
 */
public class DebugTx {

    @Test
    public void testPropagationRequiredJoinTx() {
        String configPath = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");
        PersonDao personDao = null;
        PersonServiceA personServiceA = null;
        try {
            personServiceA = (PersonServiceA) ctx.getBean("personServiceA");
            personDao = (PersonDao) ctx.getBean("personDao");
            personServiceA.addPersonWithPropagationRequired(p1, p2);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            Assert.isNull(personDao.getByName("zhangsan").getName());
        }
    }
}
