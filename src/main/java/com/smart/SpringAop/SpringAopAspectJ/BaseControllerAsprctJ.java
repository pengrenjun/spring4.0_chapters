package com.smart.SpringAop.SpringAopAspectJ;

import com.deloitte.si.core.domain.datasource.FilterFactory;
import com.deloitte.si.core.manager.GenericManager;
import com.smart.domain.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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


}
