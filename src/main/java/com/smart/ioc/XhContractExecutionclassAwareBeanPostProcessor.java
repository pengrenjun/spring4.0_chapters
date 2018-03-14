package com.smart.ioc;


import com.deloitte.si.core.utils.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/*扩展InstantiationAwareBeanPostProcessorAdapter  仅对XhContractExecution进行处理操作*/
public class XhContractExecutionclassAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    /*在实例化bean之前调用*/
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(StringUtils.equals("xhContractExecution",beanName)){
            System.out.println("在实例化XhContractExecution之前调用了InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法");
        }
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /*在实例化bean之后调用*/
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(StringUtils.equals("xhContractExecution",beanName)){
            System.out.println("在实例化XhContractExecution之后调用了InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation方法");
        }
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    /*在调用set方法,设置属性时调用*/
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if(StringUtils.equals("xhContractExecution",beanName)){
            System.out.println("在实例化XhContractExecution 在调用set方法,设置属性时调用");
        }
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }
}
