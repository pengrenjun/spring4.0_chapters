package com.smart.domain;

import org.apache.commons.lang3.RandomUtils;

import javax.sql.DataSource;

/*管理系统配置参数*/
public class SystemSettingManageInIt {

    private Integer sessionTimeOut;
    private Integer refeshCycle;
    /*加载数据源 连接数据库获取系统配置信息*/
    private DataSource dataSource;

    /*通过数据库获取系统配置信息*/
    public void initSystemSetting(){
        sessionTimeOut= RandomUtils.nextInt(300,1000);
        refeshCycle= RandomUtils.nextInt(1000,1500);
    }

    public Integer getSessionTimeOut() {
        return sessionTimeOut;
    }

    public void setSessionTimeOut(Integer sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }

    public Integer getRefeshCycle() {
        return refeshCycle;
    }

    public void setRefeshCycle(Integer refeshCycle) {
        this.refeshCycle = refeshCycle;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public  SystemSettingManageInIt(){
        /*配置系统参数(实际项目中从后台数据库中查找)*/
        SystemSetting.SESSION_TIMEOUT= RandomUtils.nextInt(0,300);
        SystemSetting.REFRESH_CYCLE=RandomUtils.nextInt(0,100);
    }

}
