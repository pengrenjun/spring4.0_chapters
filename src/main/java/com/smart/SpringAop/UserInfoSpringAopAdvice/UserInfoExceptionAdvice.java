package com.smart.SpringAop.UserInfoSpringAopAdvice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Description 用户异常抛出增强 实现AfterReturningAdvice接口
 * ThrowsAdvice是标签接口
 * @Author pengrj
 * @CreateDate 2018-04-03 下午 5:20
 * @Version 1.0
 */
public class UserInfoExceptionAdvice implements ThrowsAdvice {

    /**
     * @Description:   方法异常抛出增强实现ThrowsAdvice标签接口
     * 方法只能为void afterThrowing
     * @param :     exception    异常类型(必须作为参数,其余参数可选择添加)
     * @param :     method      目标类方法
     * @param :     args        目标实例的入参
     * @param :     target      目标类实例
     * @exception
     * @return
     * @Version:   1.0
     */
    public void afterThrowing(Method method,Object[] args,Object object,Exception exception){
        System.out.println(method.getName()+"的入参: "+args[0]+" 抛出异常： "+exception.toString());
    }
}
