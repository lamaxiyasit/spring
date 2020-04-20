package com.itheima.service.iml;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {
        try{
            txManager.begin();
            List<Account> account = accountDao.findAllAccount();
            txManager.commit();
            return account;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            txManager.begin();
            Account account = accountDao.findAccountById(accountId);
            txManager.commit();
            return account;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public void saveAccount(Account account) {

        try{
            txManager.begin();
            accountDao.saveAccount(account);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            txManager.begin();
            accountDao.updateAccount(account);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            txManager.begin();
            accountDao.deleteAccount(accountId);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account source=accountDao.findByName(sourceName);
        Account target=accountDao.findByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        int i=1/0;
        accountDao.updateAccount(target);
    }
}
