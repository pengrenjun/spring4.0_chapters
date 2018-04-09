package com.smart.SpringAop.InnerFunctionAdviceImplComponent;

import Utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description 可复用的自身代理类注入装配器 实现系统预处理接口和系统容器启动的上下文加载接口
 * @Author pengrj
 * @CreateDate 2018-04-09 下午 8:19
 * @Version 1.0
 */
@Component
public class BeanSelfProxyLoader implements SystemPretreatment, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //载入Spring容器的上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public void onReady() {
        //从容器中得到所有实现能够实现注入自身代理接口的类的集合
        Map<String, BeanSelfProxyAware> proxyAwareMap = applicationContext.getBeansOfType(BeanSelfProxyAware.class);
        //完成代理类注入的处理
        if (ObjectUtils.isNotEmpty(proxyAwareMap)) {
            for (BeanSelfProxyAware beanSelfProxyAware : proxyAwareMap.values()) {
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                if (logger.isDebugEnabled()) {
                    logger.debug("{}注册自身被代理的实例");
                }
            }

        }
    }

    @Override
    public int getOrder() {
        //将自身代理类注入装配器的加载设为优先级最高
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
