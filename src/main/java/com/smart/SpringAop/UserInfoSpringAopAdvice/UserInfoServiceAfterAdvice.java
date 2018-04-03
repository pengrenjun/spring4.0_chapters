package com.smart.SpringAop.UserInfoSpringAopAdvice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Description 用户信息后置增强 实现AfterReturningAdvice接口
 * @Author pengrj
 * @CreateDate 2018-04-03 下午 5:20
 * @Version 1.0
 */
public class UserInfoServiceAfterAdvice implements AfterReturningAdvice {
    /**
     * @Description:   方法后置增强实现AfterReturningAdvice接口
     * @param :     returnValue 目标实例返回结果
     * @param :     method      目标类方法
     * @param :     args        目标实例的入参
     * @param :     target      目标类实例
     * @exception
     * @return
     * @Version:   1.0
    */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName()+"的入参为:"+args[0]+" 返回结果为: "+returnValue);
    }
}
