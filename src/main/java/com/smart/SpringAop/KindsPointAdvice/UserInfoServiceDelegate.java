package com.smart.SpringAop.KindsPointAdvice;

import com.smart.SpringAop.UserInfoService;

/**
 * @Description 用户信息服务流程切面代理类
 * @Author pengrj
 * @CreateDate 2018-04-09 上午 11:21
 * @Version 1.0
 */
public class UserInfoServiceDelegate {

    private UserInfoService userInfoService;

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 代理类调用的方法
     * @param userId
     */
    public void getUserInfo(String userId){

        userInfoService.getUserIp(userId);
        userInfoService.getUserName(userId);
        userInfoService.getUserPassWord(userId);

    }
}
