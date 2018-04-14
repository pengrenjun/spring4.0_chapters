package com.smart.SpringAop.SpringAopAspectJ;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description AspectJ切点的详解用法
 * @Author pengrj
 * @CreateDate 2018-04-14 上午 11:29
 * @Version 1.0
 */
@Component
@Aspect
public class TestAspectJ {

    /*标注了注解NeedTest的后置方法增强*/
    @AfterReturning(value = "@annotation(com.smart.SpringAop.AnnotationTest.NeedTest)")
    public void annotationTest(){
        System.out.println("标注了注解NeedTest后置增强 执行");
    }
}
