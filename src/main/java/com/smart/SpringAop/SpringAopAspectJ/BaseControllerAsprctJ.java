package com.smart.SpringAop.SpringAopAspectJ;

import com.deloitte.si.core.domain.datasource.FilterFactory;
import com.deloitte.si.core.manager.GenericManager;
import com.smart.SpringAop.AnnotationTest.NeedTest;
import com.smart.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 控制器基类切面
 * @Author pengrj
 * @CreateDate 2018-04-11 下午 4:23
 * @Version 1.0
 */
@Component
@Aspect
public class BaseControllerAsprctJ  {

    private Logger logger= LoggerFactory.getLogger(this.getClass());



    /**
    * @Description:    用户密码信息获取方法 注意getUserPassWord(..)的写法格式 必须按照这个格式 参数放在args中
    * @param :     id
    * @exception
    * @return
    * @Version:   1.0
    */

    @Before(value = "execution(* getUserPassWord(..))&& args(id)")
    public  void   getUserPassWord(String id){

       if(logger.isDebugEnabled()){
           logger.debug("用户信息数据getUserPassWord传入参数id: "+id);
       }

    }




    @After("AspectJPointCut.argsStringType() && AspectJPointCut.haveNeedTestAnno() && AspectJPointCut.getUserIp() ")
    public  void userServiceAspectJB(){
        System.out.println("用户信息获取(入参为字符型且标注了@NeedTest注解方法且 为Ip获取方法) 后置增强开始执行");
    }


    /*获取ip获取连接点的信息 ProceedingJoinPoint用来作为环绕增强得我连接点信息*/
    @Around("AspectJPointCut.argsStringType() && AspectJPointCut.haveNeedTestAnno() && AspectJPointCut.getUserIp() ")
    public void  userServiceIpJointAcess(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("-------userIp ProceedingJoinPoint------");
        Object userId=proceedingJoinPoint.getArgs()[0];
        System.out.println("userIp 入参"+userId);

        //用新的入参进行方法的执行
       // Object res=  proceedingJoinPoint.proceed(new Object[]{"3"});
        Object res=  proceedingJoinPoint.proceed();
        System.out.println("userIp excution result: "+res);

    }


    //所有标注了NeedTest注解的方法进行匹配
    @Before("@within(needTest)")
    public void needTestAnnoTest(NeedTest needTest){

        System.out.println("@within(needTest) Aspecj test");
        //注解对象也实现了代理
        System.out.println(needTest.needFlag());
        System.out.println(needTest.description());
        System.out.println("传入的注解对象："+needTest.getClass().getName());
        System.out.println("@within(needTest) Aspecj test");

    }

    //用户信息获取绑定异常抛出
    @AfterThrowing(value = "AspectJPointCut.userInfoServiceGetPointCut()",throwing ="exc" )
    public void bindUserServiceNullPoint(NullPointerException exc){
        System.out.println("--------用户信息获取绑定了AspectJ定义的异常抛出切面------- ");
        System.out.println("AspectJ定义的异常抛出切面捕获的异常信息："+exc.getMessage());
        System.out.println("--------用户信息获取绑定了AspectJ定义的异常抛出切面-------- ");
    }


}
