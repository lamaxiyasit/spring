package com.itheima.utils;

public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //开启事务
    public void begin(){
//        try{
//            connectionUtils.getThreadConnection().setAutoCommit(false);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
        System.out.println("开启事务");
    }
    //提交事务
    public void commit(){
//        try{
//            connectionUtils.getThreadConnection().commit();
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
        System.out.println("提交事务");
    }
    //回滚事务
    public void rollback(){
//        try{
//            connectionUtils.getThreadConnection().rollback();
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
        System.out.println("回滚事务");
    }
    //释放连接
    public void release(){
//        try{
//            connectionUtils.getThreadConnection().close();
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
        System.out.println("释放连接");
    }
}
