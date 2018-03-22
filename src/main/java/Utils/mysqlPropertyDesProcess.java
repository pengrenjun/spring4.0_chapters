package Utils;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*对数据库的配置信息进行加密处理的转换方法*/
public class mysqlPropertyDesProcess extends PropertyPlaceholderConfigurer{

    private static final String[] strArr={"driverClassNameDES","urlDES","usernameDES","passwordDES"};


    /*propertyName:属性名称 propertyValue:属性值*/
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {

        if(Arrays.asList(strArr).contains(propertyName)){
            return DESUtils.getDecryptString(propertyValue);
        }
        return  propertyValue;
    }
}
