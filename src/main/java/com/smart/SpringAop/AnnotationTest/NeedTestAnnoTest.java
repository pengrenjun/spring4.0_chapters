package com.smart.SpringAop.AnnotationTest;

import Utils.ObjectUtils;
import com.alibaba.fastjson.JSONObject;
import com.smart.SpringAop.UserInfoServiceImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description 自定义注解测试
 * @Author pengrj
 * @CreateDate 2018-04-11 上午 11:40
 * @Version 1.0
 */
public class NeedTestAnnoTest {

    public static void main(String[] args) throws ClassNotFoundException {
        testNeedTestAnno();
    }

    private static void testNeedTestAnno() throws ClassNotFoundException {
        Class userServiceClazz= UserInfoServiceImpl.class;
        //获取类注解
        NeedTest clzAnnotation= (NeedTest) userServiceClazz.getAnnotation(NeedTest.class);
        if(ObjectUtils.isNotEmpty(clzAnnotation)&&clzAnnotation.needFlag()){
            System.out.println(userServiceClazz.getName()+" : "+clzAnnotation.description());
        }

        Method[] methods=userServiceClazz.getDeclaredMethods();
        if(ObjectUtils.isNotEmpty(methods)){
            for(Method method:methods){
                //获取方法的注解
                NeedTest annotation=method.getAnnotation(NeedTest.class);
                if(ObjectUtils.isNotEmpty(annotation)&&annotation.needFlag()){
                    System.out.println(userServiceClazz.getName()+"的方法:"+method.getName()+" : "+annotation.description()+" 入参："+ JSONObject.toJSONString(annotation.params()));
                }

            }
        }

    }
}
