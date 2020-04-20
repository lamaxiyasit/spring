package com.itheima.service.impl;

import com.itheima.dao.IAccountdao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

//业务层实现类
public class AcocuntServiceImpl implements IAccountService {
    private IAccountdao accountDao;
    private int i=1;
    public void saveAccount() {
        accountDao=(IAccountdao) BeanFactory.getBean("accountDao");
        accountDao.saveAccount();
        System.out.println("hello world");
    }
}
