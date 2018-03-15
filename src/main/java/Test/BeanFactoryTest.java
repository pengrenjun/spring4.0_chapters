package Test;



import com.alibaba.fastjson.JSONObject;
import com.smart.domain.Car;
import com.smart.domain.XhContractExecution;
import com.smart.ioc.XhContractExecutionBeanPostProcessor;
import com.smart.ioc.XhContractExecutionclassAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

import java.io.IOException;

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









    }
}