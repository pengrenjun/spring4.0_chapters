package com.smart.SpringAop.SpringAopAspectJ;

import com.smart.SpringAop.MemberCenterImpl;
import com.smart.SpringAop.MemberCenterInterface;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @Description 用户信息服务实现会员中心接口的引介增强切面
 * @Author pengrj
 * @CreateDate 2018-04-14 上午 10:07
 * @Version 1.0
 */
@Component
@Aspect
public class UserInfoAddMemberCenterAspecJ {

    /**
     * @Description: AspectJ为某类添加引介增强
     * @param :      com.smart.SpringAop.UserInfoServiceImpl 为UserInfoServiceImpl添加实现接口
     * @param :      MemberCenterImpl.class 默认添加接口的实现类
     * @exception
     * @return
     * @Version:   1.0
     */
    @DeclareParents(value = "com.smart.SpringAop.UserInfoServiceImpl",defaultImpl = MemberCenterImpl.class)
    //要实现的目标接口
    public MemberCenterInterface memberCenterInterface;

}
