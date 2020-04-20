package com.itheima.dao;

import com.itheima.domain.Account;

public interface IAccountDao {
    Account findAccountById(Integer accountId);
    void update(Account account);
    Account findAccountByName(String accountName);
}
