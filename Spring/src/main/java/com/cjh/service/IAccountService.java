package com.cjh.service;

import com.cjh.domain.Account;

import java.util.List;

public interface IAccountService {
    void save(Account account);
    void update(Account account);
    void delete(Integer accountId);
    Account findById(Integer accountId);
    List<Account> findAll();
}
