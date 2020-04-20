package com.cjh.utils;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();

    private DataSource dataSource;
    public Connection getThreadConnection(){
        try{
            Connection connection=tl.get();
            if(connection==null){
                connection=dataSource.getConnection();
                tl.set(connection);
            }
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void removeConnection(){
        tl.remove();
    }
}
