package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/*
    它是一个配置类，作用和bean.xml是一样的
    Configuration：
        表明当前是一个配置类
    ComponentScan:
        用于通过注解指定spring在创建容器时要扫描的包
        属性：
            value：它和basePackage的作用是一样，都是用于创建指定容器时要扫描的包
            用了该注解相当于在xml中配置了：
                <context:component-scan base-package="com.itheima"></context:component-scan>
    Bean:
        用于把当前方法的返回值作为bean对象存在ioc容器中
        属性：
            name:用于指定bean的id。当不写时，默认值是当前方法的名称
        细节：
            当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
            查找的方式与Autowired注解的作用是一样的
    Import
        用于导入其他配置类
        属性：
            value:用于指定其他配置类的字节码
                    当我们使用Import的注解之后，又Import注解类是父配置类，而导入的子配置类
    PropertySource
        用于指定properties文件的路径
        属性
            value：文件的名称和路径
            关键字：classpath，表示类路径下

 */
@ComponentScan("com.itheima")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
