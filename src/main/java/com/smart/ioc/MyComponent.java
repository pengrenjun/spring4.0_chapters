package com.smart.ioc;

import com.smart.domain.XhContractExecution;
import com.smart.ioc.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import java.util.List;
import java.util.Map;
@Component
/*通过注解注入配置测试*/
public class MyComponent<T> {

    /*对集合类进行自动注入*/
    @Autowired
    private  List<Plugin> pluginList;

    @Autowired
    private  Map<String,Plugin> pluginMap;


    public void getClassInfo(  ){
        System.out.println(pluginList.size());
    }

}


