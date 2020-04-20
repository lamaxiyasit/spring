package com.itheima.test;

import com.itheima.service.IAccountService;
import com.itheima.domain.Account;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    IAccountService accountService;
    @Test
    public void testFindAll(){
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
//        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        List<Account> accounts=accountService.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testfindOne(){
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        Account account=accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Account account=new Account();
        account.setName("12345");
        account.setMoney(12345f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Account account=accountService.findAccountById(4);
        account.setMoney(23456f);
        account.setName("12345678");
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        accountService.deleteAccount(6);
    }
}
