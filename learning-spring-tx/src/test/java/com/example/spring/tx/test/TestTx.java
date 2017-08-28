package com.example.spring.tx.test;

import com.example.spring.tx.dao.PersonDao;
import com.example.spring.tx.domain.Person;
import com.example.spring.tx.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by puroc on 2017/8/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@Rollback
//@Transactional
public class TestTx {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonService personService;

    @Test
    public void testInsert() throws Exception {
        Person person = new Person();
        person.setName("pud");
        person.setAge(36);
        personDao.insert(person);
    }

    @Test
    public void testGetByName() throws Exception {
        Assert.notNull(personDao.getByName("pud"));
    }

    @Test
    public void testPropagationRequired() throws Exception {
        Person p1 = new Person();
        p1.setName("zhangsan");
        Person p2 = new Person();
        p2.setName("lisi");
        personService.addPersonWithPropagationRequired(p1,p2);
    }
}
