package com.smart.SpringAop;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*CGLIB的动态代理 实现MethodInterceptor接口*/
public class CgligProxy implements MethodInterceptor {

    private static final Enhancer enhancer=new Enhancer();

    //创建接口实现类的实例
    public  Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //创建了子类实例
        return enhancer.create();
    }

    // o:被cglib代理的子类实例
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //织入性能检测代码
        //开始方法的检测
        PerformanceMonitor.begin(o.getClass().getName()+"."+method.getName());

        //通过代理类调用父类的方法
        Object obj=methodProxy.invokeSuper(o,objects);

        PerformanceMonitor.end();
        return  obj;

    }
}


