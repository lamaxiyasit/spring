package com.itheima.dao.impl;

import com.itheima.dao.IAccountdao;
//持久层实现类
public class AccountDaoImpl implements IAccountdao {

    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
