package com.cjh.dao;

import com.cjh.domain.Account;

import java.util.List;

public interface IAccountDao {
    void save(Account account);
    void update(Account account);
    int delete(Integer accountId);
    Account findById(Integer accountId);
    List<Account> findAll();
}
