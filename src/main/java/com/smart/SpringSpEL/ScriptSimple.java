package com.smart.SpringSpEL;

import Utils.CommonUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Description script脚本实现动态函数
 * @Author pengrj
 * @CreateDate 2018-04-17 上午 10:06
 * @Version 1.0
 */
public class ScriptSimple {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {

        //求和函数脚本
        String jstext="function sum(a,b){return a+b};";

        Object result=CommonUtils.getJsTextInvokeResult(jstext,"sum",100.1256,100.79846);

        System.out.println(result);

    }
}
