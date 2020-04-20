package com.itheima.jdbctemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao=ac.getBean("accountDao",IAccountDao.class);
        Account account=new Account();
        account.setId(1);
        account.setName("aaa");
        account.setMoney(1000f);
        accountDao.update(account);
        System.out.println(accountDao.findAccountById(1));
    }
}
