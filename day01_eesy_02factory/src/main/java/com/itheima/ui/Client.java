package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AcocuntServiceImpl;

//模拟表现层，调用业务逻辑层
public class Client {
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            IAccountService as=(IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
