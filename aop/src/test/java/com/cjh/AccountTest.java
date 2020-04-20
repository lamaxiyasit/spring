package com.cjh;

import com.cjh.domain.Account;

public class AccountTest {
    public static void main(String[] args){
        Account account=new Account();
        account.setId(3);
        account.setMoney(1000f);
        account.setName("ccc");
        account.print();
    }
}
