package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findByName(String accountName);

    void transfer(String sourceName,String targetName,Float money);
}
