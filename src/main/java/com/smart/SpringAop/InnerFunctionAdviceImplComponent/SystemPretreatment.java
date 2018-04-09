package com.smart.SpringAop.InnerFunctionAdviceImplComponent;

import org.springframework.core.Ordered;

/*系统启动预处理接口 实现系统组件加载优先级接口*/
public interface SystemPretreatment extends Ordered {

    void onReady();
}
