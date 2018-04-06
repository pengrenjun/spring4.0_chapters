package com.smart.SpringAop.UserInfoSpringAopAdvice;

/*引介增强的增强的控制接口*/
public interface MonitorInterface {

    //是否开启前置增强
    void setBeforeAdvice(Boolean beforeAdvice);
    //是否开启后置增强
    void setAfterAdvice(Boolean afterAdvice);
}
