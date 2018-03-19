package com.smart.ioc;

import com.deloitte.si.core.utils.StringUtils;
import com.smart.domain.User;

import java.beans.PropertyEditorSupport;

/*用户的属性自定义编辑器(相当于后处理器)*/
public class UserPropertyEditor extends PropertyEditorSupport {

    /*主要重写这个方法完成将字面值 通过自定义编辑器为User bean的属性赋值*/
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        if(StringUtils.isNotEmpty(text)){
            User user=new User();
            String[] userInfo=text.split(",");
            user.setUserId(Integer.parseInt(userInfo[0]));
            user.setPassword(userInfo[1]);
            /*设置转换后的属性对象*/
            super.setValue(user);
        }
        else {
            try {
                throw  new Exception("传入的字符串有误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
