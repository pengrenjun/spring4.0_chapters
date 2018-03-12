package com.smart.domain;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.deloitte.si.core.domain.GenericEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

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
public class XhContractExecution  extends GenericEntity  {


    private static final long serialVersionUID = 7084228519608966618L;
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

    /**
     * 核销状态
     */
    @Column(name = "APPLY_STATUS")
    private String applyStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "xhContractExecution", cascade = CascadeType.REFRESH)
    private Set<XhContractExecutionDetail> xhContractExecutionDetailSet;

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
        this.contractNumber = contractNumber;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
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


}
