package com.smart.ioc;

import com.smart.domain.XhContractExecution;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/*通过实现FactoryBean接口,简化bean实例化的配置*/
public class FactoryBeanXhContractExecution implements FactoryBean<XhContractExecution> {


   /*配置Map格式的解析的信息,用于实例化Bean */

    private Map<String,Object> infoMap=new HashMap<>();

    public Map<String, Object> getInfoMap() {
        return infoMap;
    }


    public void setInfoMap(Map<String, Object> infoMap) {
        this.infoMap = infoMap;
    }

    @Override
    public XhContractExecution getObject() throws Exception {
        /*String[] info=xhContractExecutionInfo.split(",");*/
        XhContractExecution xhContractExecution=new XhContractExecution();
        xhContractExecution.setDeptName(String.valueOf(infoMap.get("deptName")));
        xhContractExecution.setId(String.valueOf(infoMap.get("id")));
        return xhContractExecution;
    }

    @Override
    public Class<?> getObjectType() {
        return XhContractExecution.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
