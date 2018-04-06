package com.smart.SpringAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*性能检测横切代码块实现 jdK java.lang.reflect.InvocationHandler */
public class PerformenceJdkProxyHandle implements InvocationHandler{
    //目标业务类(需要被代理的业务实例对象)
    private  Object target;

    public PerformenceJdkProxyHandle(Object target) {
        this.target = target;
    }

    //原业务层的横切代码:PerformanceMonitor.begin("com.smart.SpringAop.ForumServiceImpl.removeTopic");

    @Override
    /**
     * @Param proxy   最终代理实例
     * @Param method  具体的方法
     * @Param args    方法的入参
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //性能检测横切代码块
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        //通过反射方法调用业务类的目标方法 业务逻辑代码
        Object obj=method.invoke(target,args);
        PerformanceMonitor.end();
        return obj;
    }
}
