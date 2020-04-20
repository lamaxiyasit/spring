package com.cjh;

import com.cjh.domain.Account;
import com.cjh.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
    private IAccountService accountService;
    @Before
    public void init(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        accountService=applicationContext.getBean("accountService",IAccountService.class);
    }
    @Test
    public void test(){
       accountService.transfer("aaa","bbb",100f);
    }
}
