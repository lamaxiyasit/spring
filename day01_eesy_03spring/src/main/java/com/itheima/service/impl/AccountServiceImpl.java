package com.itheima.service.impl;

import com.itheima.dao.IAccountdao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountdao accountDao=new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
