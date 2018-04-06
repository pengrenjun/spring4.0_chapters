package com.smart.SpringAop;


import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.smart.domain.User;
import org.apache.commons.lang.ObjectUtils;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

//用户信息获取实现类
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public String getUserName(String userId) {
        return getUserInfoById(userId).getUserName();
    }

    @Override
    public String getUserIp(String userId) {
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
}


