package com.smart.SpringAop;


import com.google.common.collect.Maps;
import com.smart.SpringAop.AnnotationTest.NeedTest;
import com.smart.SpringAop.InnerFunctionAdviceImplComponent.BeanSelfProxyAware;
import com.smart.SpringAop.SpringAopAspectJ.BaseControllerAsprctJ;
import com.smart.domain.User;

import java.util.Date;
import java.util.Map;

//用户信息获取实现类(实现织入自身代理类的自定义接口BeanSelfProxyAware)
@NeedTest(needFlag = true,description = "用户信息用户信息获取接口实现")
public class UserInfoServiceImpl extends BaseControllerAsprctJ implements UserInfoService  /*,BeanSelfProxyAware*/ {

    private UserInfoServiceImpl userInfoServiceImpl;

    @Override
    @NeedTest(needFlag = true,description = "用户信息用户名获取",params = {"1"})
    public String getUserName(String userId) {
        return getUserInfoById(userId).getUserName();
    }

    @Override
    public String getUserIp(String userId) {
        /*在方法内调用其他方法,需要进行处理才能对调用的方法实现增强*/
        getUserName(userId);
        getUserPassWord(userId);

        return getUserInfoById(userId).getLastIp();
    }

    @Override
    public String getUserPassWord(String userId) {
        return getUserInfoById(userId).getPassword();
    }

    //模拟数据库的信息
    private User getUserInfoById(String userId){
        Map<String ,User> userMap= Maps.newHashMap();
        userMap.put("1",new User(1, "小明", "123456", 100, "10.10.10.20", new Date()));
        userMap.put("2",new User(2, "小李", "123456789", 1000, "10.30.10.25", new Date()));
        User user= userMap.get(userId);
        if(Utils.ObjectUtils.isEmpty(user)){
            throw new NullPointerException("id:为 "+userId+"的用户在数据库中没有信息记录");
        }
        return  user;
    }

    //织入自身代理类
    //@Override
    public void setSelfProxy(Object obj) {
        //将当前类转换为代理类
        this.userInfoServiceImpl=(UserInfoServiceImpl) obj;
    }
}


