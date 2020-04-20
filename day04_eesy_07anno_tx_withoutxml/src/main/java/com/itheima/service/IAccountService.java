package com.itheima.service;

import com.itheima.domain.Account;

public interface IAccountService {
    Account findAccountByName(String accountName);
    void transfer(String sourceName,String targetName,Float money);
}
