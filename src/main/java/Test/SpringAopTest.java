package Test;

import com.smart.SpringAop.ForumService;
import com.smart.SpringAop.ForumServiceImpl;
import com.smart.SpringAop.JdkProxyForumServiceImpl;
import com.smart.SpringAop.PerformenceHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SpringAopTest {

    public static void main(String[] args) {
        //测试第一个实例:拥有性能检测能力的ForumServiceImpl业务方法
        testFirstInstance();
        //通过jdk的动态代理 测试拥有性能检测能力的ForumServiceImpl业务方法
        testJdkProxyForumServieImpl();


    }
    //通过自定义的代理器PerformenceHandle将检测代码块与业务实例的代码块进行合并处理
    private static void testJdkProxyForumServieImpl() {
        //创建待被代理业务实例
        ForumService proxyTarget=new JdkProxyForumServiceImpl();


        PerformenceHandle performenceHandle=new PerformenceHandle(proxyTarget);

        //获取代理后的业务实例(绑定了性能检测)
        ForumService proxyForumService=(ForumService)getProxyInstance(proxyTarget,performenceHandle);
        proxyForumService.removeTopic(10);
        proxyForumService.removeForum(134);

    }


    public static void  testFirstInstance(){

        ForumService forumService=new ForumServiceImpl();
        forumService.removeTopic(1241);
        forumService.removeForum(311234);

    }

    public static Object getProxyInstance(Object obj, InvocationHandler handler){
     return    Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
