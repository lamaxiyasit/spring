package com.itheima.service.impl;

import com.itheima.dao.IAccountdao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
        scope="" init-method="" destroy-method="">
        <property name="" value=""/ref=""></property>
    </bean>
用于创建对象的
    他们的作用就和xml配置文件中编写一个<bean>标签实现的功能时一样的
        @Controller：一般用于表现层的注解。
        @Service：一般用于业务层的注解。
        @Repository：一般用于持久层的注解。
用于注入数据的
    他们的作用就和xml配置文件中的bean标签中写一个property标签的作用时一样的
    Autowired:
        作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以诸注入成功
            如果ioc容器中没有任何bean的类型和要注入的变量类型相匹配，则报错。
            如果ioc容器有多个类型匹配
    Qualifier:
        作用：在按照类中注入的基础之上再按照名称注入。
             直接按照bean的id注入。可以独立使用
        属性：
              name：用于指定bean的id
    Value：
        作用：用于注入基本表达式和String类型的数据
        属性：
            value:用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式)
                SpEl的写法：${表达式}

用于改变作用范围的
    他们的作用就和在bean标签中使用scope属性实现的功能是一样

和生命周期相关
    他们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的
 */
@Component("accountService")
@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name="accountDao2")
    private IAccountdao accountDao2=null;
    public void saveAccount() {
        accountDao2.saveAccount();
    }
}
