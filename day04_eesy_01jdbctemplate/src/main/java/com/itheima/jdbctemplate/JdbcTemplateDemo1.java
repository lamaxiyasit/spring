package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/eesy?serverTimezone=GMT&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("1234567890");
        JdbcTemplate jt=new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money) values('ccc',1000)");
    }
}
