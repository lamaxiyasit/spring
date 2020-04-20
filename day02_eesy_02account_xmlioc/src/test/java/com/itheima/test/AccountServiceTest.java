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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Before
    public void init(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        as=applicationContext.getBean("accountService",IAccountService.class);
    }
    @Test
    public void transfer(){
        as.transfer("aaa","bbb",100f);
    }
    @Test
    public void testFindAll(){
        //3、执行方法
        List<Account> accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //3、执行方法
//        Account account=as.findAccountById(1);
//        System.out.println(account);
        System.out.println("执行");
    }
    @Test
    public void testSave(){
        Account account=new Account();
        account.setName("test");
        account.setMoney(12345f);
        //3、执行方法
        as.saveAccount(account);

    }
    @Test
    public void testUpdate(){
        //3、执行方法
        Account account=as.findAccountById(5);
        account.setMoney(23456f);
        as.updateAccount(account);
        System.out.println(account);
    }
    @Test
    public void testDelete(){
        //3、执行方法
        as.deleteAccount(4);
    }
}
