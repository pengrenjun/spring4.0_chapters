package com.smart.SpringAop.SpringAopAspectJ;

import Utils.ObjectUtils;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description SpringAop基于Schema配置增强的方法
 * @Author pengrj
 * @CreateDate 2018-04-16 下午 3:28
 * @Version 1.0
 */
public class AspectJSchemaAdviceMethods {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    /*前置增强*/
    public void getUserInfoServiceBeforeAdvice(String userId)  {

        System.out.println("用户信息获取基于Schema配置的前置增强 入参:"+userId);

    }

    /*后置增强*/
    public void getUserInfoServiceAfterReAdvice(Object result,String userId){
        if(ObjectUtils.isNotEmpty(result)){
        System.out.println("用户信息获取基于Schema配置的后置增强 返回结果："+result.toString());}
    }

    /*环绕增强*/
    public  void getUserPassWord(ProceedingJoinPoint proceedingJoinPoint,String userId) throws Throwable {
        System.out.println("用户信息获取基于Schema配置的 密码环绕增强 入参："+proceedingJoinPoint.getArgs()[0].toString());
        System.out.println("用户信息获取基于Schema配置的 密码环绕增强 方法执行结果："+proceedingJoinPoint.proceed().toString());

    }

    /*异常抛出增强*/
    public void userServiceNullPointAdvice(NullPointerException nullpoint,String userId){

        if(logger.isDebugEnabled()){
            logger.debug("用户信息 id:{}获取异常信息--- {} 增强处理",userId,nullpoint.getMessage());
        }

    }


}
