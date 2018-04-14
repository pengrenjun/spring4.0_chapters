package com.smart.SpringAop;

/*会员中心服务接口,用于用户信息获取的引介增强测试*/
public interface MemberCenterInterface {

    Boolean isMember(String id);

    Integer getCredits(String id);
}
