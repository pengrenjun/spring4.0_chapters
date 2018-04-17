package com.smart.SpringSpEL;

import Utils.CommonUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.smart.domain.XhContractExecution;
import com.smart.domain.XhContractExecutionDetail;
import org.springframework.core.convert.support.StringToCharsetConverter;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description spring SpEL表达式使用测试
 * @Author pengrj
 * @CreateDate 2018-04-17 上午 11:04
 * @Version 1.0
 */
public class SpElExpressionTest {

    public static void main(String[] args) {
        testSimpleExp();
        //测试对象属性值的获取
        testPropertyVal();
    }

    private static void testPropertyVal() {
        ExpressionParser parser=new SpelExpressionParser();

        XhContractExecution xhContractExecution=new XhContractExecution();
        xhContractExecution.setId("123");
        XhContractExecutionDetail xhContractExecutionDetail=new XhContractExecutionDetail();
        xhContractExecutionDetail.setEntityId("456");
        xhContractExecution.setXhContractExecutionDetail(xhContractExecutionDetail);

        System.out.println("主表的主键"+CommonUtils.getPoJoPropertyValue(xhContractExecution,"id",String.class));
        System.out.println("从表的外键"+CommonUtils.getPoJoPropertyValue(xhContractExecution,"xhContractExecutionDetail.entityId",String.class));
    }

    private static void testSimpleExp() {

        ExpressionParser parser=new SpelExpressionParser();

        Expression expression=parser.parseExpression("'a'+'b'+'c'");

        System.out.println(expression.getValue());

        System.out.println(CommonUtils.textParsing("0x7fffffff",Integer.class));

    }
}


