package com.smart.SpringAop.SpringAopAspectJ;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description AspectJ切点命名
 * @Author pengrj
 * @CreateDate 2018-04-14 下午 3:41
 * @Version 1.0
 */
public class AspectJPointCut {

    //UserInfoService实现类
    @Pointcut("target(com.smart.SpringAop.UserInfoService)")
    public  void userInfoServiceGetPointCut(){};

    //含有NeedTest注解的方法
    @Pointcut("@annotation(com.smart.SpringAop.AnnotationTest.NeedTest)")
    public  void haveNeedTestAnno(){};

    //入参为String类型的方法
    @Pointcut( "args(String)")
    public  void argsStringType(){};

    //用户Ip信息获取
    @Pointcut("execution(* *Ip(..))")
    public void getUserIp(){};
}
