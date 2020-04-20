package com.cjh.service;

import com.cjh.domain.Account;

public interface IAccountService {
    public Account findAccountByName(String accountName);
    public void transfer(String sourceName,String targetName,Float money);
}
