package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Producer producer=new Producer();
        /*
            动态代理：
                特点：字节码随用随创建，随用随增强
                作用：不修改源码的基础上对方法增强
                分类：
                    基于接口的动态代理
                    基于子类的动态代理
                基于接口的动态代理：
                    涉及的类：Proxy
                    提供者：JDK官方
                如何创建代理对象：
                    使用Proxy类中的newProxyInstance方法
                创建代理对象的要求：
                    被代理对象最少实现一个接口，如果没有则不能使用
                newProxyInstance方法的参数：
                    ClassLoader：类加载器
                        它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法
                    Class[]：字节码数组
                        他是用于代理对象和被代理对象有相同的方法。固定写法
                    InvocationHandler：用于提供增强的代码
                        它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况都是匿名内部类，但不是必须的
                        此接口的实现类谁用谁写
         */
        IProducer proxyproducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                /*
                    作用：执行被代理对象的任何接口方法都会经过该方法
                    方法参数的含义
                    proxy  代理对象的引用
                    method 当前执行的方法
                    args   当前执行方法的参数
                           和被代理对象有相同的返回值
                 */
                Object returnValue=null;
                Float money=(Float)args[0];
                if("saleProduct".equals(method.getName())){
                    returnValue =method.invoke(producer,money*0.8f);
                }
                if("afterService".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.5f);
                }
                return returnValue;
            }
        });
        proxyproducer.saleProduct(10000f);
        proxyproducer.afterService(10000f);
    }
}
