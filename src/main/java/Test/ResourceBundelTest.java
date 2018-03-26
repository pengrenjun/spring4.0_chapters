package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/*通过ResourceBundel加载不同地区的的资源文件信息*/
public class ResourceBundelTest {

    public static void main(String[] args) throws InterruptedException {

        ResourceBundle cnRes=ResourceBundle.getBundle("resource", Locale.CHINESE);
        System.out.println(cnRes.getString("one"));

        ResourceBundle usRes=ResourceBundle.getBundle("resource", Locale.US);
        System.out.println(usRes.getString("one"));

        /*动态配置资源文件信息*/

        //加载区域资源文件 cnRes usRes
        //用本地化格式配置区域资源文件
        Object params[]={new Date()};
        String cnStr=new MessageFormat(cnRes.getString("one"),Locale.CHINA).format(params);
        System.out.println(cnStr);

        String enStr=new MessageFormat(cnRes.getString("one"),Locale.US).format(params);
        System.out.println(enStr);

        /*通过配置MessageSource的实现类ResourceBundleMessageSource,批量加载不同区域资源文件信息*/
        //简化了上面的资源加载方式
        ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

        //获取MessageSource的配置Bean
        MessageSource messageSource= (MessageSource) ctx.getBean("resourceBean");

        String cnMessage=messageSource.getMessage("one",params,Locale.CHINA);
        String enMessage=messageSource.getMessage("one",params,Locale.US);
        System.out.println("通过MessageSource加载文件信息"+cnMessage);
        System.out.println("通过MessageSource加载文件信息"+enMessage);

        //定时刷新资源配置测试
        MessageSource reMessage=(MessageSource)ctx.getBean("reloadSourceBean");
        String aEnMessage=reMessage.getMessage("one",params,Locale.US);
        System.out.println("刷新前的信息"+aEnMessage);
        Thread.sleep(20000);
        String bEnMessage=reMessage.getMessage("one",params,Locale.US);
        System.out.println("刷新后的信息"+bEnMessage);











    }
}
