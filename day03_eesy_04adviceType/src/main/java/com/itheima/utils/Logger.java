package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

//用于记录日志的工具类，它里面提供了公共的代码
public class Logger {
    //用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
    //前置通知
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintlog方法开始记录日志了。。。。");
    }

    //后置通知
    public void afterReturnPrintLog(){
        System.out.println("后置通知Logger类中的afterReturnPrintLog方法开始记录日志了。。。。");
    }

    //异常通知
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。。");
    }


    //最终通知
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。。");
    }

    /*
        环绕通知
        问题：
             当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
        分析：
             通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
        解决：
             Spring框架为我们提供了一个接口，ProceedingJoinPoint，该接口有一个方法proceed(),此方法相当于明确的调用切入方法
             该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
        spring的环绕通知：
            它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方法。
     */
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try{
            Object[] args=pjp.getArgs();
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。。");
            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。。");
            return rtValue;
        }catch (Throwable e){
            throw new RuntimeException(e);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。。");
        }
    }
}
