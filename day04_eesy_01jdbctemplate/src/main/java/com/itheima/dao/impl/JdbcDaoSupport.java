package com.itheima.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//public class JdbcDaoSupport {
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//    private JdbcTemplate jdbcTemplate;
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        if (jdbcTemplate==null){
//            jdbcTemplate=createJdbcTemplate(dataSource);
//        }
//    }
//
//    private JdbcTemplate createJdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    private DataSource dataSource;
//
//}
