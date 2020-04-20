package com.itheima.utils;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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
