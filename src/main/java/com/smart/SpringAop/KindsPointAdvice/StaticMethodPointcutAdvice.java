package com.smart.SpringAop.KindsPointAdvice;

import com.smart.SpringAop.UserInfoService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @Description: 静态类注释方法匹配切面(定义增强额切入规则) 需要实现StaticMethodMatcherPointcutAdvisor方法
 * @Author：pengrj
 * @Date : 2018/4/6 0006 12:46
 * @version:1.0
 */
public class StaticMethodPointcutAdvice extends StaticMethodMatcherPointcutAdvisor {
    @Override
    /**
     * @Author:  pengrj
     * @Description: 切点方法匹配规则 为用户信息获取的密码方法创建切面
     * @Param  method
     * @Param  aClass
     * @Return boolean
     * @Date: Created in 2018/4/6 0006 12:49
     */
    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("静态方法切点传入的方法名称： "+method.getName());
        if(method.getName().equals("getUserPassWord")){
            return true;
        }
        return false;
    }

    @Override
    /**
     * @Author:  pengrj
     * @Description:  重写切点类的匹配规则
     * 匹配用户信息获取的UserInfoService类及其子类 (isAssignableFrom的使用)
     * @Return org.springframework.aop.ClassFilter
     * @Date: Created in 2018/4/6 0006 12:51
     */
    public ClassFilter getClassFilter() {

        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("静态方法切点类的传入类："+aClass.getName());
                return UserInfoService.class.isAssignableFrom(aClass);
            }
        };
    }
}
