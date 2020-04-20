package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
//        List<Account> accounts=jt.query("select * from account where money>=?",new BeanPropertyRowMapper<Account>(Account.class),1000);
//        for(Account account:accounts){
//            System.out.println(account);
//        }
        Long count=jt.queryForObject("select count(*) from account where money>=?",Long.class,1000f);
        System.out.println(count);
    }
}
