package com.smart.SpringAop;

import com.smart.domain.User;

/*用户信息获取接口*/
public interface UserInfoService {
    String getUserName(String userId);
    String getUserIp(String userId);
    String getUserPassWord(String userId);
}
