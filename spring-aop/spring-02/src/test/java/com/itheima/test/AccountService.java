package com.itheima.test;

import com.itheima.config.JdbcConfig;
import com.itheima.config.SpringConfiguration;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
/*
    使用junit单元测试，测试我们的配置
    Spring整合junit的配置
        1、导入spring整合的junit的jar包
        2、使用junit提供的一个注解把原有的main方法替换掉了，替换成spring提供的@Runwith
        3、告知spring的运行期，spring和ioc创建是基于xml还是注解，并且说明位置
                location：指定xml位置，加上classpath关键字，表示类路径下
                classes：指定注解类所在的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountService {
    @Autowired
    private IAccountService accountService;
    @Test
    public void testFindAll(){
        List<Account> accounts=accountService.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        Account account=accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account=new Account();
        account.setName("test");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }

    @Test
    public void testDelete(){
        accountService.deleteAccount(4);
    }

    @Test
    public void testUpdate(){
        Account account=new Account();
        account.setId(5);
        account.setName("test");
        account.setMoney(2345f);
        accountService.updateAccount(account);
    }
}
