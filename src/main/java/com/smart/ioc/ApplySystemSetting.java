package com.smart.ioc;

import com.smart.domain.SystemSetting;

/*应用到系统配置的参数*/
public class ApplySystemSetting {

    public void soutCurrentSystemSetting(){

        System.out.println("当前配置的系统参数"+ SystemSetting.SESSION_TIMEOUT+","+ SystemSetting.REFRESH_CYCLE);
    }
}
