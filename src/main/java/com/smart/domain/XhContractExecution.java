package com.smart.domain;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.deloitte.si.core.domain.GenericEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * XhContractExecution 兴华合同执行信息对象
 *
 * @Decription 兴华合同执行信息
 * @author pengrj
 * @date 2018-2-27
 * @version 1.0.0
 */
@Entity
@Table(name = "T_FORM_RECEIPT_APPLY_SUMMARY")
public  class XhContractExecution  extends GenericEntity implements BeanFactoryAware, BeanNameAware, InitializingBean/*,InstantiationAwareBeanPostProcessor,BeanPostProcessor 通过注册自定义后处理器实现*/ {


    private static final long serialVersionUID = 7084228519608966618L;

    public XhContractExecution() {
        System.out.println("【1】.XhContractExecution初始化调用构造器（调用构造器之前先调用InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法）");
        System.out.println("在调用构造器实例化bean之后 调用InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation方法对bean进行处理");
    }

    /*带参数的构造函数*/
    public XhContractExecution(String formNo, String customerName) {
        this.formNo = formNo;
        this.customerName = customerName;
    }


    public XhContractExecution(String formNo, XhContractExecutionDetail xhContractExecutionDetail) {
        this.formNo = formNo;
        this.xhContractExecutionDetail = xhContractExecutionDetail;
    }

    /*通过级联属性直接为其对象的属性赋值,需要声明初始化对象*/
    /*Caused by: org.springframework.beans.NullValueInNestedPathException:
    Invalid property 'jlxhContractExecutionDetail' of bean class [com.smart.domain.XhContractExecution]:
    Value of nested property 'jlxhContractExecutionDetail' is null*/
     private  XhContractExecutionDetail jlxhContractExecutionDetail=new XhContractExecutionDetail();

    public XhContractExecutionDetail getJlxhContractExecutionDetail() {
        return jlxhContractExecutionDetail;
    }

    public void setJlxhContractExecutionDetail(XhContractExecutionDetail jlxhContractExecutionDetail) {
        this.jlxhContractExecutionDetail = jlxhContractExecutionDetail;
    }
     /*通过级联属性直接为其对象的属性赋值,需要声明初始化对象*/


     /*集合类型为Map的属性注入配置*/
     private HashMap<String,XhContractExecutionDetail> xhMap;

     /*自定义的类型,通过自定义属性编辑器完成属性的注入*/
     private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, XhContractExecutionDetail> getXhMap() {
        return xhMap;
    }

    public void setXhMap(HashMap<String, XhContractExecutionDetail> xhMap) {
        this.xhMap = xhMap;
    }



    /**
     * t_form_main  id
     */
    @Column(name = "MAIN_PK_ID")
    private String mainPkId;


    /**
     * 单据号
     */
    @Column(name = "FORM_NO")
    private String formNo;


    /**
     * 合同主表id
     */
    @Column(name = "CONTRACT_ID")
    private String contractId;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    /**
     * 合同编号
     */
    @Column(name = "CONTRACT_NUMBER")
    private String contractNumber;

    /**
     * 合同类型
     */
    @Column(name = "CONTRACT_TYPE")
    private String contractType;


    /**
     * 客户id
     */
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    /**
     * 客户名称
     */
    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    /**
     * 项目id
     */
    @Column(name = "PROJECT_ID")
    private String projectId;

    /**
     * 项目名称
     */
    @Column(name = "PROJECT_NAME")
    private String projectName;

    /**
     * 部门名称
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     * 部门id
     */
    @Column(name = "DEPT_ID")
    private String deptId;

    /**
     * 业务合伙人
     */
    @Column(name = "BUSINESS_PARTER")
    private String businessParter;

    /**
     * 合同金额
     */
    @Column(name = "CONTRACT_AMOUNT")
    private BigDecimal contractAmount=new BigDecimal(0.00);

    /**
     * 签订日期
     */
    @Column(name = "SIGNING_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(format = "yyyy-MM-dd")
    private Date signingDate;

    /**
     * 实际收款比例
     */
    @Column(name = "RECEIPT_PERCENTAGE")
    private String receiptPrecentage;

    /**
     * 实际收款金额
     */
    @Column(name = "RECEIPT_AMOUNT")
    private BigDecimal receiptAmount=new BigDecimal(0.00);

    /**
     * 执行状态
     */
    @Column(name = "STATUS")
    private String status;

    private XhContractExecutionDetail xhContractExecutionDetail;

    public XhContractExecutionDetail getXhContractExecutionDetail() {
        return xhContractExecutionDetail;
    }

    public void setXhContractExecutionDetail(XhContractExecutionDetail xhContractExecutionDetail) {
        this.xhContractExecutionDetail = xhContractExecutionDetail;
    }

    /**
     * 核销状态
     */
    @Column(name = "APPLY_STATUS")
    private String applyStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "xhContractExecution", cascade = CascadeType.REFRESH)
    private Set<XhContractExecutionDetail> xhContractExecutionDetailSet;

    /*list的Spring配置*/
    private List<XhContractExecutionDetail> xhContractExecutionDetailList;

    public List<XhContractExecutionDetail> getXhContractExecutionDetailList() {
        return xhContractExecutionDetailList;
    }

    public void setXhContractExecutionDetailList(List<XhContractExecutionDetail> xhContractExecutionDetailList) {
        this.xhContractExecutionDetailList = xhContractExecutionDetailList;
    }

    public void setXhContractExecutionDetailSet(Set<XhContractExecutionDetail> xhContractExecutionDetailSet) {
        this.xhContractExecutionDetailSet = xhContractExecutionDetailSet;
    }

    public String getxhContractExecutionDetailSet() {
        if(CollectionUtils.isNotEmpty(this.xhContractExecutionDetailSet)){
            return JSONObject.toJSONString(this.xhContractExecutionDetailSet);
        }else{
            return null;
        }
    }

    public Set<XhContractExecutionDetail> getCollectionXhContractExecutionDetailSet() {
        return xhContractExecutionDetailSet;
    }

    public void getContractInfo(){
        System.out.println("合同编号："+this.contractNumber+"合同类型:"+this.contractType+"id:"+this.getId()+"部门名称:"+this.deptName);
    }

    public void initMethod(){

        System.out.println("【6】.xhContractExecution初始化执行初始化方法initMethod");
        System.out.println("此后将调用BeanPostProcessor中的postProcessAfterInitialization方法,再次获得对bean的加工处理机会");
    }

    public String getMainPkId() {
        return mainPkId;
    }

    public void setMainPkId(String mainPkId) {
        this.mainPkId = mainPkId;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        System.out.println("【2】.bean初始化调用setContractNumber");
        System.out.println("配置属性之前先调用InstantiationAwareBeanPostProcessor的postProcessPropertyValues方法");
        this.contractNumber = contractNumber;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        System.out.println("【2】.bean初始化调用setContractType");
        System.out.println("配置属性之前先调用InstantiationAwareBeanPostProcessor的postProcessPropertyValues方法");
        this.contractType = contractType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getBusinessParter() {
        return businessParter;
    }

    public void setBusinessParter(String businessParter) {
        this.businessParter = businessParter;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    public String getReceiptPrecentage() {
        return receiptPrecentage;
    }

    public void setReceiptPrecentage(String receiptPrecentage) {
        this.receiptPrecentage = receiptPrecentage;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【4】.调用BeanFactoryAware的setBeanFactory方法"+JSONObject.toJSONString(beanFactory));
        System.out.println("装配了BeanPostProcessor,则将调用postProcessBeforeInitialization方法对bean进行加工处理,入参bean为当前的bean beanName 是当前bean的配置名称");
        System.out.println("用户可以通过postProcessBeforeInitialization方法对bean进行特殊处理,AOP 动态代理都是通过BeanPostProcessor进行实施");
    }

    @Override
    public void setBeanName(String name) {

        System.out.println("【3】.调用BeanNameAware的setBeanName方法"+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【5】.调用InitializingBean的afterPropertiesSet方法");


    }
    /*已下实现为后处理器,一般不由bean本身实现,他们独立于bean,在spring创建bean的时候这些后处理器都会发生作用,可以对感兴趣的bean进行加工处理*//*
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation方法");
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor的postProcessPropertyValues方法");
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor的postProcessBeforeInitialization方法");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor的postProcessAfterInitialization方法");
        return null;
    }*/
}
