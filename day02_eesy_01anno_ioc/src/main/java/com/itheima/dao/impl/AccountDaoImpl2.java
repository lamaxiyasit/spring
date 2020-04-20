package com.itheima.dao.impl;

import com.itheima.dao.IAccountdao;
import org.springframework.stereotype.Repository;

//持久层实现类
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountdao {
    public void saveAccount() {
        System.out.println("保存了账户222222222");
    }
}
