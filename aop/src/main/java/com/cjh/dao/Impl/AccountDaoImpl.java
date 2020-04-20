package com.cjh.dao.Impl;

import com.cjh.dao.IAccountDao;
import com.cjh.domain.Account;
import com.cjh.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private ConnectionUtils connectionUtils;
    @Override
    public Account findAccountByName(String accountName) {
        try{
            return queryRunner.query(connectionUtils.getThreadConnection(), "select *  from account where name=?",new BeanHandler<Account>(Account.class),accountName);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try{
            queryRunner.update(connectionUtils.getThreadConnection(), "update account set name=?,money=? where id=? ",
                    account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
