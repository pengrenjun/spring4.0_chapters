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

        //测试通过命名切点配置切面的实现 并获取连接点的信息
        //testAspectJPointCut();

        //用户信息获取绑定异常抛出
        //testUserServiceNuLLPointAspctJ();

        //基于Schema配置切面的初步配置测试(各种增强的Schema配置)
        //testSpringAopSchema();
        //测试基于SpringAop Schema配置的Advisor(一个切点和一个切面相结合)
        testSpringAopSchemaAdvisor();

    }

    private static void testSpringAopSchemaAdvisor() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("springAop-Schema.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        System.out.println("测试基于SpringAop Schema配置的Advisor(一个切点和一个切面相结合)");
        proxyUserService.getUserName("1");
    }

    private static void testSpringAopSchema() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("springAop-Schema.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        proxyUserService.getUserIp("1");
        proxyUserService.getUserPassWord("2");
        /*异常抛出增强*/
        //proxyUserService.getUserPassWord("3");
        MemberCenterInterface memberCenterInterface=(MemberCenterInterface)proxyUserService;
        String userId="1";

        System.out.println("用户信息引入会员服务增强");
       if(memberCenterInterface.isMember(userId)){
           System.out.printf("id为:%s 的用户是会员,当前积分：%s",userId, memberCenterInterface.getCredits(userId));
       }
    }

    private static void testUserServiceNuLLPointAspctJ() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("springAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        proxyUserService.getUserPassWord("3");
    }

    private static void testAspectJPointCut() {

        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("springAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        proxyUserService.getUserPassWord("1");
        //getUserName标注了注解
        proxyUserService.getUserIp("2");
    }

    private static void testAspectJAnnotationByxml() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("springAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        proxyUserService.getUserPassWord("1");
        //getUserName标注了注解
        proxyUserService.getUserName("2");
    }

    private static void testAspectJIntroduceByxml() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("springAop-AspectJ.xml");
        UserInfoService proxyUserService= (UserInfoService) ctx.getBean("userInfoService");
        //强制类型转换
        MemberCenterInterface memberCenter=(MemberCenterInterface) proxyUserService;
        String userId="1";
        if(memberCenter.isMember(userId)){
            System.out.printf("id 为 %s 的用户为会员",userId);
        }
    }

    private static void testSpringAspectJByXml() {
        ApplicationContext ctx= BeanFactoryTest.getApplicationContextByXml("springAop-AspectJ.xml");
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
