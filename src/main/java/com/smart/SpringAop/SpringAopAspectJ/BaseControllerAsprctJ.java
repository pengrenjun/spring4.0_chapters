package com.smart.SpringAop.SpringAopAspectJ;

import com.deloitte.si.core.domain.datasource.FilterFactory;
import com.deloitte.si.core.manager.GenericManager;
import com.smart.domain.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 控制器基类切面
 * @Author pengrj
 * @CreateDate 2018-04-11 下午 4:23
 * @Version 1.0
 */
@Aspect
public class BaseControllerAsprctJ implements  Serializable {
    @Autowired
    private GenericManager commonManager;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
    * @Description:    保存修改方法
    * @param :     id
    * @exception
    * @return
    * @Version:   1.0
    */

    @Before(value = "execution(* saveorsubmit(id))")
    public  void   saveorsubmit(Object id){

       if(logger.isDebugEnabled()){
           logger.debug("用户信息数据保存修改saveorsubmit传入参数id: "+id);
       }

        this.commonManager.saveOrUpdate((Serializable) id);
    }
    /**
    * @Description:    用户信息查找
    * @param :     ids
    * @exception
    * @return
    * @Version:   1.0
    */
    @After(value = "execution(* saveorsubmit(ids))")
    public List<User> getUserInfolists(Object[] ids){
        if(logger.isDebugEnabled()){
            logger.debug("用户信息数据getUserInfolists传入参数ids: "+ids.toString());

        }
        return  this.commonManager.findEntityByFilter(FilterFactory.in("userId",ids));
    }

}
