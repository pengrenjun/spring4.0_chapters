package com.smart.SpringAop.UserInfoSpringAopAdvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description 用户信息环绕增强 实现aopalliance提供的MethodInterceptor接口
 * @Author pengrj
 * @CreateDate 2018-04-03 下午 5:20
 * @Version 1.0
 */
public class UserInfoServiceAroundAdvice implements MethodInterceptor {
    /**
     * @Description:   方法环绕增强实现MethodInterceptor接口
     * @param :     methodInvocation 封装了目标方法还有入参数组
     * @exception
     * @return     Object
     * @Version:   1.0
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //目标方法的入参数组
        Object args[]=methodInvocation.getArguments();
        //获得入参id
        String userId= String.valueOf(args[0]);
        //前置处理
        System.out.println(methodInvocation.getMethod().getName()+"的传入参数："+userId);

        //通过反射机制调用目标方法(执行方法)返回方法的返回的值
        Object object=methodInvocation.proceed();

        //后置处理
        System.out.println(methodInvocation.getMethod().getName()+"的入参为:"+args[0]+" 返回结果为: "+object.toString());

        return object;
    }
}
