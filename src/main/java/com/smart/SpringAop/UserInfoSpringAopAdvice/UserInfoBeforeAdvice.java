package com.smart.SpringAop.UserInfoSpringAopAdvice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description 用户信息前置增强
 * @Author pengrj
 * @CreateDate 2018-04-03 下午 2:58
 * @Version 1.0
 */
public class UserInfoBeforeAdvice implements MethodBeforeAdvice {

    /**
     * @Description:  前置增强实现MethodBeforeAdvice接口(用来打印方法的传入参数)
     * @param :    method 目标类方法
     * @param :    args   目标类方法入参
     * @param :    target 目标类
     * @exception
     * @return
     * @Version:   1.0
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String UserId= String.valueOf(args[0]);
        System.out.println(method.getName()+"的传入参数："+UserId);
    }
}
