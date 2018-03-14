package Test;

import com.smart.domain.Beans;
import com.smart.domain.Car;
import com.smart.domain.XhContractExecution;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*采用应用上下文加载bean*/

public class  ApplicationContextTest<T,K> {


    public static void main(String[] args) {
        Car car=getBeanByAnnotationConfig(Beans.class,Car.class,"car");
        car.introduce();
    }


    /*通过配置信息提供类得到实体bean*/
    public static <T,K>  K getBeanByAnnotationConfig(Class<T> configClz,Class<K> getClz,String beanName){

        return  (K)new AnnotationConfigApplicationContext(configClz).getBean(beanName,getClz);
    }





}
