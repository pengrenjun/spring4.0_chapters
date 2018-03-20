package Test;



import com.alibaba.fastjson.JSONObject;
import com.smart.domain.Car;
import com.smart.domain.SystemSetting;
import com.smart.domain.XhContractExecution;
import com.smart.domain.XhContractExecutionDetail;
import com.smart.ioc.*;
import org.apache.cxf.wsdl11.SOAPBindingUtil;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.*;

/*通过BeanFactory加载实体bean对象*/
public class BeanFactoryTest {

    public static void main(String[] args) throws IOException {

        /*XmlBeanDefinitionReader通过Resource装载spring的配置信息并启动ioc容器*/
        Resource resource=PatternResolverTest.getResourceArrPatternResolver("beans.xml")[0];

        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);

        /*向启动的ioc容器factory注册后自定义的处理器(可以注入多个后处理器)*/
        factory.addBeanPostProcessor(new XhContractExecutionBeanPostProcessor());
        factory.addBeanPostProcessor(new XhContractExecutionclassAwareBeanPostProcessor());


        XhContractExecution xhContractExecutionA=factory.getBean("xhContractExecution",XhContractExecution.class);
        xhContractExecutionA.getContractInfo();
        //xhContractExecutionB是从缓存池中获取的 这块和XML中的scope设置有关 scope默认设为singleton(存入缓冲池) 设为prototype则创建新的实例
        XhContractExecution xhContractExecutionB=factory.getBean("xhContractExecution",XhContractExecution.class);
        System.out.println("从缓存池获取的实例指向同一个引用："+""+(xhContractExecutionA==xhContractExecutionB));
        /*关闭容器*/
        factory.destroySingleton("xhContractExecution");

        XhContractExecution xhContractExecutionC=factory.getBean("xhContractExecution",XhContractExecution.class);
        System.out.println("从缓存池获取的实例指向同一个引用："+""+(xhContractExecutionA==xhContractExecutionC));

        /*通过属性注入和构造函数创建的对象*/
        XhContractExecution xhContractExecutionD=factory.getBean("xhContractExecutionD",XhContractExecution.class);
        System.out.println(JSONObject.toJSONString(xhContractExecutionD));


        /*通过属性注入方式解决循环注入的问题*/
        XhContractExecution xhContractExecutionE=factory.getBean("xhContractExecutionE",XhContractExecution.class);
        System.out.println(JSONObject.toJSONString(xhContractExecutionE));


        /*spring配置非静态工厂方法 生成bean*/
        XhContractExecution xhContractExecutionF=factory.getBean("xhContractExecutionF",XhContractExecution.class);
        System.out.println(JSONObject.toJSONString(xhContractExecutionF));


        /*spring配置静态工厂方法 生成bean*/
        XhContractExecution xhContractExecutionG=factory.getBean("xhContractExecutionG",XhContractExecution.class);
        System.out.println(JSONObject.toJSONString(xhContractExecutionG));

        /*xml特殊字符的处理*/
        XhContractExecutionDetail xhContractExecutionDetailB=factory.getBean("xhContractExecutionDetailB",XhContractExecutionDetail.class);
        System.out.println(JSONObject.toJSONString(xhContractExecutionDetailB));


        /*子容器引入父容器bean*/
        //父容器
        ClassPathXmlApplicationContext UpapplicationContext=new ClassPathXmlApplicationContext(new String[]{"UpLevelBeans.xml"});
        //子容器引入父容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"beans.xml"},UpapplicationContext);
        XhContractExecutionDetail xhContractExecutionDetailC=applicationContext.getBean("xhContractExecutionDetailC",XhContractExecutionDetail.class);
        System.out.println(JSONObject.toJSONString(xhContractExecutionDetailC.getXhContractExecution()));

        XhContractExecution xhContractExecutionH=applicationContext.getBean("xhContractExecutionH",XhContractExecution.class);
        System.out.println("级联属性设置  "+xhContractExecutionH.getJlxhContractExecutionDetail().getPeriod_name());

        /*集合类型的属性配置 list*/
        XhContractExecution xhContractExecutionI=applicationContext.getBean("xhContractExecutionI",XhContractExecution.class);
        System.out.println("集合类型的属性配置 list"+JSONObject.toJSONString(xhContractExecutionI.getXhContractExecutionDetailList()));



        /*集合类型的属性配置 Map*/
        XhContractExecution xhContractExecutionJ=applicationContext.getBean("xhContractExecutionJ",XhContractExecution.class);
        System.out.println("集合类型的属性配置 Map"+JSONObject.toJSONString(xhContractExecutionJ.getXhMap()));

        /*lookup方法注入 创建新实例*/

        abstractXhcontractExecution xhcontractExecution=applicationContext.getBean("singleXhContractExeInterface",abstractXhcontractExecution.class);
        XhContractExecutionDetail xhContractExecutionDetailPro=xhcontractExecution.getPrototypeXhContractExecutionDetail();
        System.out.println(JSONObject.toJSONString(xhContractExecutionDetailPro)+" "+xhContractExecutionDetailPro.hashCode());

        /*通过bean的依赖应用系统配置的系统参数*/
        SystemSetting currentSystemSetting=applicationContext.getBean("currentSystemSetting",SystemSetting.class);
        ApplySystemSetting applySystemSetting=new ApplySystemSetting();
        applySystemSetting.soutCurrentSystemSetting();

        /*引用bean 的名字*/
        XhContractExecutionDetail xhContractExecutionDetailF=applicationContext.getBean("xhContractExecutionDetailF",XhContractExecutionDetail.class);
        System.out.println("引用id："+xhContractExecutionDetailF.getEntityId());


        /*通过FactoryBean接口配置bean的信息,简化实例配置*/
        /*获得FactoryBean实体需要加上&进行标记*/
        FactoryBean<XhContractExecution> factoryBeanXhContractExecution=applicationContext.getBean("&CEfactoryBeanXhContractExecution",FactoryBean.class);
        try {
            XhContractExecution xhContractExecutionFactoryCreate=factoryBeanXhContractExecution.getObject();
            System.out.println("通过FactoryBean接口配置bean的信息,简化实例配置:"+xhContractExecutionFactoryCreate.getDeptName()+" "+xhContractExecutionFactoryCreate.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        XhContractExecution CExhContractExecution=applicationContext.getBean("CEfactoryBeanXhContractExecution",XhContractExecution.class);
        System.out.println("通过FactoryBean接口配置bean的信息,简化实例配置:"+CExhContractExecution.getDeptName()+" "+CExhContractExecution.getId());


        XhContractExecution editorXhContractExection=applicationContext.getBean("editorXhContractExection",XhContractExecution.class);
        System.out.println("自定义属性编辑器："+JSONObject.toJSONString(editorXhContractExection));

    }


}
