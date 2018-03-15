package com.smart.ioc;

import com.smart.domain.XhContractExecution;
import org.apache.commons.lang3.RandomUtils;

import java.util.Date;

/*XhContractExecution 创建工厂 可以通过spring完成配置注册*/
public class XhContractExecutionFactory {


    /*非静态方法生成bean 需要先实例化工厂*/
    public XhContractExecution getXhContractExecutionBean(){

        XhContractExecution xhContractExecution=new XhContractExecution();
        xhContractExecution.setId(String.valueOf(RandomUtils.nextInt(1,1000000)));
        xhContractExecution.setCreatedDate(new Date());
        return xhContractExecution;
    }

    /*静态工厂方法生成bean 直接调用*/
    public static XhContractExecution staticGetXhContractExecutionBean(){

        XhContractExecution xhContractExecution=new XhContractExecution();
        xhContractExecution.setId(String.valueOf(RandomUtils.nextInt(1,1000000)));
        xhContractExecution.setCreatedDate(new Date());
        return xhContractExecution;
    }
}
