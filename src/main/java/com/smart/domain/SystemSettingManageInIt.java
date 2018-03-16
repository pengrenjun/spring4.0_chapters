package com.smart.domain;

import org.apache.commons.lang3.RandomUtils;

/*管理系统配置参数*/
public class SystemSettingManageInIt {


    public  SystemSettingManageInIt(){
        /*配置系统参数(实际项目中从后台数据库中查找)*/
        SystemSetting.SESSION_TIMEOUT= RandomUtils.nextInt(0,300);
        SystemSetting.REFRESH_CYCLE=RandomUtils.nextInt(0,100);
    }

}
