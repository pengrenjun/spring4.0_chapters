package Test;

import com.alibaba.fastjson.JSONObject;
import com.smart.SpringAop.*;
import com.smart.SpringAop.UserInfoSpringAopAdvice.UserInfoBeforeAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SpringAopTest {

    public static void main(String[] args) {
        //测试第一个实例:拥有性能检测能力的ForumServiceImpl业务方法
        //testFirstInstance();
        //通过jdk的动态代理 测试拥有性能检测能力的ProxyForumServiceImpl业务方法
        //testJdkProxyForumServieImpl();
        //通过CGLIB的动态代理  测试拥有性能检测能力的ProxyForumServiceImpl业务方法
        //testCglibProxyForumServieImpl();
        //用户信息获取前置增强(打印调用方法的入参)
        //testBeforeAdvice();
        //用户信息获取 前置与后置增强(打印调用方法的入参,打印返回的结果)
        testBeforeAndAfterAdvice();


    }

    private static void testBeforeAndAfterAdvice() {

        //通过springXml配置设置前置代理
        ApplicationContext ctx=BeanFactoryTest.getApplicationContextByXml("UpLevelBeans.xml");
        //采用Cglib动态代理配置
        UserInfoServiceImpl proxyUserInfoServiceXml=(UserInfoServiceImpl)ctx.getBean("userInforServiceProxyB");
        System.out.println("----------------------Cglib动态代理的前置后置配置---------------------------------------------");
        proxyUserInfoServiceXml.getUserPassWord("2");
    }

    private static void testBeforeAdvice() {
        //创建代理的目标类
        UserInfoService userInfoService=new UserInfoServiceImpl();
        //得到前置增强
        BeforeAdvice userBeforeAdvice=new UserInfoBeforeAdvice();
        //spring的代理工厂(通过jdk和Cglib的动态代理将增强加入到代理目标中)
        ProxyFactory proxyFactory=new ProxyFactory();
        //采用jdk动态代理(指定接口信息)
        proxyFactory.setInterfaces(userInfoService.getClass().getInterfaces());
        //设置代理目标(默认Cglib代理)
        proxyFactory.setTarget(userInfoService);
        //设置前置增强(可以设置多个前置增强,调用顺序和添加顺序相同)
        proxyFactory.addAdvice(userBeforeAdvice);
        //得到代理的实例
        UserInfoService proxyUserInfoService=(UserInfoService)proxyFactory.getProxy();
        System.out.println(JSONObject.toJSONString(proxyUserInfoService));
        //代理后的方法测试
        System.out.println(proxyUserInfoService.getUserName("1"));


        //通过springXml配置设置前置代理
        ApplicationContext ctx=BeanFactoryTest.getApplicationContextByXml("UpLevelBeans.xml");
        //采用Cglib动态代理配置
        UserInfoServiceImpl proxyUserInfoServiceXml=(UserInfoServiceImpl)ctx.getBean("userInforServiceProxyA");
        System.out.println("----------------------Cglib动态代理的前置配置---------------------------------------------");
        proxyUserInfoServiceXml.getUserIp("2");
    }

    //通过CGLIB的动态代理  测试拥有性能检测能力的ProxyForumServiceImpl业务方法
    private static void testCglibProxyForumServieImpl() {
        //创建待被代理业务实例
        CgligProxy cgligProxy = new CgligProxy();
        //通过动态生成子类的方式创建cglib代理类  com.smart.SpringAop.ProxyForumServiceImpl$$EnhancerByCGLIB$$a33f825d
        ProxyForumServiceImpl cglibProxyTarget = (ProxyForumServiceImpl) cgligProxy.getProxy(ProxyForumServiceImpl.class);
        System.out.println(cglibProxyTarget.getClass());
        cglibProxyTarget.removeTopic(1341);
        cglibProxyTarget.removeForum(2342);

    }

    //通过自定义的代理器PerformenceHandle将检测代码块与业务实例的代码块进行合并处理
    private static void testJdkProxyForumServieImpl() {
        //创建待被代理业务实例
        ForumService proxyTarget = new ProxyForumServiceImpl();

        //性能检测处理器(实现对业务实例对象的代理)
        PerformenceJdkProxyHandle performenceHandle = new PerformenceJdkProxyHandle(proxyTarget);

        //获取代理后的业务实例(绑定了性能检测) jdk的动态代理仅支持对接口的代理
        ForumService proxyForumService = (ForumService) getProxyInstance(proxyTarget, performenceHandle);
        proxyForumService.removeTopic(10);
        proxyForumService.removeForum(134);

    }


    public static void testFirstInstance() {

        ForumService forumService = new ForumServiceImpl();
        forumService.removeTopic(1241);
        forumService.removeForum(311234);

    }

    public static Object getProxyInstance(Object obj, InvocationHandler handler) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}
