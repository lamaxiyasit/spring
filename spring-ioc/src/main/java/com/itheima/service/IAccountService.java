package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findAccountById(Integer accountId);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
}
