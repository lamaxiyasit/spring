package com.itheima.service.impl;
import com.itheima.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;
    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name=name;
        this.birthday=birthday;
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了"+name+","+age+","+birthday);
    }
}
