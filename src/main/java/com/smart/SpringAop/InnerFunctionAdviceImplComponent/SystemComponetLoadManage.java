package com.smart.SpringAop.InnerFunctionAdviceImplComponent;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Description 系统组件启动管理器
 * 通过监听spring容器的ContextRefreshedEvent事件调用容器中所有实现SystemPretreatment接口的组件
 * @Author pengrj
 * @CreateDate 2018-04-09 下午 8:51
 * @Version 1.0
 */
@Component
public class SystemComponetLoadManage implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<SystemPretreatment > systemPretreatmentList= Lists.newArrayList();

    private Boolean hasTrigger=Boolean.FALSE;


    //注入所有SystemPretreatment组件
    @Autowired(required = false)
    public void setSystemPretreatmentList(List<SystemPretreatment> systemPretreatmentList) {
        Assert.notEmpty(systemPretreatmentList,"系统中没有实现SystemPretreatment接口的组件");
        OrderComparator.sort(systemPretreatmentList);
        this.systemPretreatmentList = systemPretreatmentList;
    }

    //触发所有的组件
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if(!hasTrigger){
            for(SystemPretreatment systemPretreatment:systemPretreatmentList){
                systemPretreatment.onReady();
                if(logger.isDebugEnabled()){
                    logger.debug("执行插件{}",systemPretreatment.getClass().getName());
                }
            }
        }else {
            if(logger.isDebugEnabled()){
                logger.debug("容器中的插件已经启动了");
            }
        }

    }
}
