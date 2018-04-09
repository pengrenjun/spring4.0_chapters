package com.smart.SpringAop.KindsPointAdvice;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @Description 流程切点与方法名切点相交的切点
 * @Author pengrj
 * @CreateDate 2018-04-09 下午 1:59
 * @Version 1.0
 */
public class UserServiceComposablePointCut {

    private Pointcut userServicecomposablePointCut;


    public Pointcut getUserServicecomposablePointCut() {

        //创建复合切点
        ComposablePointcut composablePointCut=new ComposablePointcut();

        //创建流程切点
        Pointcut pt1=new ControlFlowPointcut(UserInfoServiceDelegate.class,"getUserInfo");

        //创建方法名切点
        NameMatchMethodPointcut pt2=new NameMatchMethodPointcut();
        pt2.addMethodName("getUserPassWord");

       return composablePointCut.intersection(pt1).intersection((Pointcut) pt2);

    }

}
