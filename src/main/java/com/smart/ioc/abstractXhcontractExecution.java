package com.smart.ioc;

import com.smart.domain.XhContractExecutionDetail;

public abstract class abstractXhcontractExecution {

    /*lookUp方法注入,每次创建单例的XhContractExecution,但对应的XhContractExecutionDetail却是不同的(新的实例)*/

    /*CGlib在运行期间动态创建实现方法*/
        public     abstract XhContractExecutionDetail getPrototypeXhContractExecutionDetail();

}
