package com.smart.SpringAop.UserInfoSpringAopAdvice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @Description:   引介增强继承DelegatingIntroductionInterceptor类,实现自定义MonitorInterface的用户信息的增强控制接口
 * @param :      methodInvocation 封装了目标方法还有入参数组
 * @exception
 * @return     Object
 * @Version:   1.0
 */
public class UserInfoServiceIntroduceAdvice extends DelegatingIntroductionInterceptor implements MonitorInterface{


    /*线程的变量*/
    private ThreadLocal<Boolean> tbeforeAdvice=new ThreadLocal<>();
    private ThreadLocal<Boolean> tafterAdvice=new ThreadLocal<>();


    @Override
    public void setBeforeAdvice(Boolean beforeAdvice) {
        tbeforeAdvice.set(beforeAdvice);
    }

    @Override
    public void setAfterAdvice(Boolean afterAdvice) {
        tafterAdvice.set(afterAdvice);
    }

    /**
     *重写 invoke 方法
     * @Param mi 目标方法
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //通过线程变量进行前置后置增强的控制
        //方法入参
        Object userId=mi.getArguments()[0];
        if(tbeforeAdvice.get()){
            System.out.println(mi.getMethod().getName()+"的传入参数："+userId);
        }

        Object obj= super.invoke(mi);

        if(tafterAdvice.get()){
            System.out.println(mi.getMethod().getName()+"的入参为:"+userId+" 返回结果为: "+obj.toString());

        }
        tbeforeAdvice.remove();
        tafterAdvice.remove();
        return  obj;
    }
}
