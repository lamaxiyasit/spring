package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Before
    public void init(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        as=applicationContext.getBean("accountService",IAccountService.class);
    }
    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }
    @Test
    public void testfindAll(){
        System.out.println("hello world");
        as.findAllAccount();
    }
}
