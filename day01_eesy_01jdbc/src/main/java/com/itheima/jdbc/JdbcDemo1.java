package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eesy?serverTimezone=GMT","root","1234567890");
        PreparedStatement pstm=connection.prepareStatement("select * from account");
        ResultSet rs=pstm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstm.close();
        connection.close();
    }
}
