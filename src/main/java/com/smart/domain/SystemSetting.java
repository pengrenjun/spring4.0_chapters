package com.smart.domain;

/*系统配置参数*/
public class SystemSetting {

    public  static int SESSION_TIMEOUT=300;
    public  static int REFRESH_CYCLE=100;

    private Integer sessionTimeOut;
    private Integer refeshCycle;

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
}
