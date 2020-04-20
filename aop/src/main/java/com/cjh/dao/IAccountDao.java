package com.cjh.dao;

import com.cjh.domain.Account;

public interface IAccountDao {
    public Account findAccountByName(String accountName);
    public void update(Account account);
}
