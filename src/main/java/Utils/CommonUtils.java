package Utils;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Description 常用方法工具类
 * @Author pengrj
 * @CreateDate 2018-04-17 上午 10:15
 * @Version 1.0
 */
public class CommonUtils extends ObjectUtils {

    private static  ScriptEngine scriptEngine;
    private static  Invocable invocable;
    /**
     * 创建文本表达式解析器
     */
    private static ExpressionParser parser=new SpelExpressionParser();
    /**
     * SpEL解析上下文
     */
    private static EvaluationContext evaluationContext;

    /**
    * @Description:   创建JavaScript脚本引擎
    * @return         ScriptEngine
    * @Version:       1.0
    */
    public static ScriptEngine getJavaScriptEngine(){

        //创建脚本引擎管理器
        ScriptEngineManager manager=new ScriptEngineManager();
        //创建JavaScript脚本引擎
        scriptEngine=manager.getEngineByName("JavaScript");
        return  scriptEngine;
    }


    /**
     * @Description: 获取JavaScript脚本的执行结果
     * @param :    jsText 执行的脚本文本
     * @param :    functionName 执行的方法名称
     * @param :    args  方法传参
     * @exception: ScriptException, NoSuchMethodException
     * @return result
     * @Version:   1.0
     */
    public static  Object getJsTextInvokeResult(String jsText,String functionName,Object...args) throws ScriptException, NoSuchMethodException {
        getJavaScriptEngine().eval(jsText);
        invocable=(Invocable)scriptEngine;
        return invocable.invokeFunction(functionName,args);
    }


    /**
     * @Description: 将文本表达式装换为特定数据类型
     * @param :     textToParse 文本表达式(支持运算操作符解析包括:关系操作符,运算操作符 三元操作符)
     * @param :     desiredResultType 数据转换的目标类型
     * @return      T
     * @Version:   1.0
     */
    public static<T> T  textParsing(String textToParse, Class<T> desiredResultType){
        return  parser.parseExpression(textToParse).getValue(desiredResultType);
    }

    /**
     * @Description: 对象属性解析(获取对象的属性值,支持对象的嵌套对象信息的获取)
     * @param :     target 解析的目标对象
     * @param :     propertyName 要获取的属性值名称(支持对象的嵌套对象信息格式,支持？.格式的安全导航操作符)
     * @param :     desiredResultType 数据转换的目标类型
     * @return      T
     * @Version:   1.0
     */
    public static<T> T getPoJoPropertyValue(Object target,String propertyName,Class<T> desiredResultType){
        evaluationContext=new StandardEvaluationContext(target);
        return parser.parseExpression(propertyName).getValue(evaluationContext,desiredResultType);
    }


}
