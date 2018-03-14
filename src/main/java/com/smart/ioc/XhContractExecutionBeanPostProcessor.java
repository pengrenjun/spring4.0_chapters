package com.smart.ioc;


import com.deloitte.si.core.utils.StringUtils;
import com.google.common.base.Predicate;
import com.smart.domain.XhContractExecution;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class XhContractExecutionBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(StringUtils.equals(beanName,"xhContractExecution")){

            Predicate<XhContractExecution> predicate=new Predicate<XhContractExecution>() {
                @Override
                public boolean apply(XhContractExecution input) {
                    if(StringUtils.isNotEmpty(input.getId())){
                        return true;
                    }
                    return false;
                }
            };

            if(!predicate.apply((XhContractExecution)bean)){
                ((XhContractExecution) bean).setId("123456789");
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(StringUtils.equals(beanName,"xhContractExecution")){

            Predicate<XhContractExecution> predicate=new Predicate<XhContractExecution>() {
                @Override
                public boolean apply(XhContractExecution input) {
                    if(StringUtils.isNotEmpty(input.getDeptName())){
                        return true;
                    }
                    return false;
                }
            };

            if(!predicate.apply((XhContractExecution)bean)){
                ((XhContractExecution) bean).setDeptName("审计一部");
            }
        }

        return bean;

    }
}
