package com.cjh.service.impl;

import com.cjh.dao.IAccountDao;
import com.cjh.domain.Account;
import com.cjh.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer accountId) {
        accountDao.delete(accountId);
    }

    @Override
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
