package Test;

import com.smart.SpringAop.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SpringAopTest {

    public static void main(String[] args) {
        //测试第一个实例:拥有性能检测能力的ForumServiceImpl业务方法
        testFirstInstance();
        //通过jdk的动态代理 测试拥有性能检测能力的ProxyForumServiceImpl业务方法
        testJdkProxyForumServieImpl();
        //通过CGLIB的动态代理  测试拥有性能检测能力的ProxyForumServiceImpl业务方法
        testCglibProxyForumServieImpl();


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
