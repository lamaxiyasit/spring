package com.itheima.test;


import config.SpringConfig;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void test(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        QueryRunner queryRunner1=applicationContext.getBean("queryRunner",QueryRunner.class);
        QueryRunner queryRunner2=applicationContext.getBean("queryRunner",QueryRunner.class);
        System.out.println(queryRunner1==queryRunner2);
    }
}
