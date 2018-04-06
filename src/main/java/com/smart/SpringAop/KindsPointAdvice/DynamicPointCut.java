package com.smart.SpringAop.KindsPointAdvice;

import com.google.common.collect.Lists;
import com.smart.SpringAop.UserInfoService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description: 动态切面(根据方法入参动态的绑定增强) 需要扩展DynamicMethodMatcherPointcut
 * @Author：pengrj
 * @Date : 2018/4/6 0006 15:09
 * @version:1.0
 */
public class DynamicPointCut extends DynamicMethodMatcherPointcut {

    //模拟用户中心的所有id数据
    private static List<String> userIds= Lists.newArrayList();
    static {
        userIds.add("1");
        userIds.add("2");
    }

    /**
      * @Author:  pengrj
      * @Description:    要重写类的静态切点检查,提升动态切面连接点的检测效率
      * @Param
      * @Return
      * @Date: Created in 2018/4/6 0006 15:12
      */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("对类： "+aClass.getName()+"进行静态的切点检测");
                return UserInfoService.class.isAssignableFrom(aClass);
            }
        };
    }
    
    /**
      * @Author:  pengrj
      * @Description: 要重写方法的静态切点检查,提升动态切面连接点的检测效率
      * @param  method
      * @param  targetClass
      * @Return boolean
      * @Date: Created in 2018/4/6 0006 15:16
      */

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("对方法："+method.getName()+"进行静态的切点检测");
        if("getUserIp".equals(method.getName())){
            return true;
        }
        return false;
    }

    /**
      * @Author:  pengrj
      * @Description:  对方法进行动态的切点检测
      * @param   method
      * @param aClass
      * @param objects
      * @Return boolean
      * @Date: Created in 2018/4/6 0006 15:16
      */
    @Override
    public boolean matches(Method method, Class<?> aClass, Object[] objects) {
        System.out.println("对方法："+method.getName()+"的入参: "+objects[0].toString()+"进行动态切点检测");
        if(userIds.contains(objects[0].toString())){
            return true;
        }

        return false;
    }
}
