package com.smart.SpringAop;

import Utils.ObjectUtils;
import com.google.common.collect.Maps;
import com.smart.domain.User;

import java.util.Date;
import java.util.Map;

/**
 * @Description 会员中心服务接口实现类
 * @Author pengrj
 * @CreateDate 2018-04-14 上午 9:58
 * @Version 1.0
 */
public class MemberCenterImpl  implements  MemberCenterInterface{

    private static Map<String ,User> userMap= Maps.newHashMap();

    static {
        userMap.put("1",new User(1, "小明", "123456", 100, "10.10.10.20", new Date()));
        userMap.put("2",new User(2, "小李", "123456789", 1000, "10.30.10.25", new Date()));

    }


    @Override
    public Boolean isMember(String id) {
        if(ObjectUtils.isEmpty(userMap.get(id))){
            System.out.printf("id为 %s 的用户不是会员",id);
            return  false;
        }
        return  true;
    }

    @Override
    public Integer getCredits(String id) {
        if(this.isMember(id)){
            return  ((User)userMap.get(id)).getCredits();
        }
        else {return 0;}
    }
}
