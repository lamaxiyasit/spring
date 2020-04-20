package com.cjh.dao.impl;

import com.cjh.dao.IAccountDao;
import com.cjh.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public void save(Account account) {
        try{
            queryRunner.update("insert into account (name,money) values(?,?)",account.getName(), account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try{
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Integer accountId) {
        try{
            return queryRunner.update("delete from account where id=?",accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findById(Integer accountId) {
        try{
            return queryRunner.query("select * from account where id=?", new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> findAll() {
        try{
            return queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
