package Test;


import com.smart.SpringAop.MemberCenterImpl;
import com.smart.SpringAop.MemberCenterInterface;
import com.smart.SpringAop.SpringAopAspectJ.BaseControllerAsprctJ;
import com.smart.SpringAop.UserInfoService;
import com.smart.SpringAop.UserInfoServiceImpl;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;


/**
 * @Description AspeicJ用法测试
 * @Author pengrj
 * @CreateDate 2018-04-11 下午 6:05
 * @Version 1.0
 */
public class SpringAopAspectJTest {

    public static void main(String[] args) {
        //编码方式测试AspeicJ用法
        //testSpringAspectJ();
        //springXml配置方式测试AspectJ的配置
        //testSpringAspectJByXml();

        //测试用户信息服务中引入会员系统的引介增强
        //testAspectJIntroduceByxml();

        //测试标注注解的@annotation切点
        //testAspectJAnnotationByxml();

        //测试通过命名切点配置切面的实现
        testAspectJPointCut();
    }

    private static void testAspectJPointCut() {

        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("spingAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        proxyUserService.getUserPassWord("1");
        //getUserName标注了注解
        proxyUserService.getUserIp("2");
    }

    private static void testAspectJAnnotationByxml() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("spingAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        proxyUserService.getUserPassWord("1");
        //getUserName标注了注解
        proxyUserService.getUserName("2");
    }

    private static void testAspectJIntroduceByxml() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("spingAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        //强制类型转换
        MemberCenterInterface memberCenter=(MemberCenterInterface) proxyUserService;
        String userId="1";
        if(memberCenter.isMember(userId)){
            System.out.printf("id 为 %s 的用户为会员",userId);
        }
    }

    private static void testSpringAspectJByXml() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("spingAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        proxyUserService.getUserPassWord("1");
    }

    private static void testSpringAspectJ() {

        UserInfoServiceImpl userInfoService=new UserInfoServiceImpl();

        AspectJProxyFactory aspectJProxyFactory=new AspectJProxyFactory();

        //设置目标对象
        aspectJProxyFactory.setTarget(userInfoService);
        //添加切面类
        aspectJProxyFactory.addAspect(BaseControllerAsprctJ.class);
        //生成织入切面的代理类
        UserInfoServiceImpl proxyUserService=aspectJProxyFactory.getProxy();

        proxyUserService.getUserPassWord("2");



    }
}
