package com.cjh.service.Impl;

import com.cjh.dao.IAccountDao;
import com.cjh.domain.Account;
import com.cjh.service.IAccountService;
import com.cjh.utils.TransactionManager;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    @Override
    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account source=accountDao.findAccountByName(sourceName);
        Account target=accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.update(source);
        //int i=1/0;
        accountDao.update(target);
    }
}
