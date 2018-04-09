package com.smart.SpringAop.InnerFunctionAdviceImplComponent;


/**
 * @Description: 可注入自身代理类接口
 * @Author：pengrj
 * @Date : 2018/4/9 0006 15:09
 * @version:1.0
 */
public interface BeanSelfProxyAware {
    /*织入自身代理类*/
    void setSelfProxy(Object obj);
}
