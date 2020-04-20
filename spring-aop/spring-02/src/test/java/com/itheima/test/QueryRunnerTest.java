package com.itheima.test;

import com.itheima.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void testQueryRunner(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner1=applicationContext.getBean("runner",QueryRunner.class);
        QueryRunner queryRunner2=applicationContext.getBean("runner",QueryRunner.class);
        System.out.println(queryRunner1==queryRunner2);
    }
}
