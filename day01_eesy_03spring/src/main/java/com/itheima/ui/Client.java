package com.itheima.ui;

import com.itheima.dao.IAccountdao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.logging.XMLFormatter;



/*
    核心容器的接口：
    ApplicationContext: 单例对象
            创建对象是立即加载，只要一读取配置文件，就马上创建配置文件中的对象
    BeanFactory:  多例对象
            创建对象是延迟加载，根据id获取对象时才会创建对象
 */
public class Client {
    public static void main(String[] args){
//        //获取核心容器对象
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        //根据id获取bean对象
//        IAccountService as=ac.getBean("accountService",IAccountService.class);
//        IAccountdao adao=ac.getBean("accountDao",IAccountdao.class);
//        System.out.println(as);
//        System.out.println(adao);
        //---------BeanFactory----------
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        IAccountService as=(IAccountService) factory.getBean("accountService",IAccountService.class);
        System.out.println(as);
    }
}
