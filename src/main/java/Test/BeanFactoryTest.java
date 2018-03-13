package Test;



import com.smart.domain.Car;
import com.smart.domain.XhContractExecution;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

import java.io.IOException;

/*通过BeanFactory加载实体bean对象*/
public class BeanFactoryTest {

    public static void main(String[] args) throws IOException {


        Resource resource=PatternResolverTest.getResourceArrPatternResolver("beans.xml")[0];

        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        /*XmlBeanDefinitionReader通过Resource装载spring的配置信息并启动ioc容器*/
        reader.loadBeanDefinitions(resource);

        Car car= (Car) factory.getBean("car");

        car.introduce();

        XhContractExecution xhContractExecution=factory.getBean("xhContractExecution",XhContractExecution.class);
        xhContractExecution.getContractInfo();



    }
}
