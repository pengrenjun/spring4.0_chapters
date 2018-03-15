package com.smart.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.deloitte.si.core.domain.GenericEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * XhContractExecutionDetail 兴华合同执行收款核销信息明细对象
 *
 * @Decription 兴华合同执行收款核销信息
 * @author pengrj
 * @date 2018-2-27
 * @version 1.0.0
 */
@Entity
@Table(name = "T_FORM_RECEIPT_APPLY_DETAIL")
public class XhContractExecutionDetail extends GenericEntity {

    public XhContractExecutionDetail() {
    }

    public XhContractExecutionDetail(String period_name, XhContractExecution xhContractExecution) {
        this.period_name = period_name;
        this.xhContractExecution = xhContractExecution;
    }

    /**
     *父表单id
     */
    @Column(name = "ENTITY_ID")
    private String entityId;

    /**
     *从表排序序号
     */
    @Column(name = "LINE_NUMBER")
    private String lineNumber;

    /**
     *阶段名称
     */
    @Column(name = "PERIOD_NAME")
    private String period_name;

    /**
     *收款条款id(阶段id)
     */
    @Column(name = "CONTRACT_RECEIVABLE_ID")
    private String contract_receivable_id;

    /**
     * 预计收款日期
     */
    @Column(name = "EXCEPTED_RECEIPT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(format = "yyyy-MM-dd")
    private Date exception_receipt_date;

    /**
     * 预计收款比例
     */
    @Column(name = "EXCEPTED_RECEIPT_PERCENTAGE")
    private String exceptionReceiptPrecentage;

    /**
     * 预计收款金额
     */
    @Column(name = "EXCEPTED_RECEIPT_AMOUNT")
    private BigDecimal exceptionReceiptAmount=new BigDecimal(0.00);

    /**
     * 收款单号
     */
    @Column(name = "RECEIPT_NO")
    private String receiptNo;

    /**
     * 收款id
     */
    @Column(name = "RECEIPT_INFO_ID")
    private String receiptInfoId;

    /**
     * 实际收款日期
     */
    @Column(name = "RECEIPT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(format = "yyyy-MM-dd")
    private Date receipt_date;


    /**
     * 实际收款金额
     */
    @Column(name = "RECEIPT_AMOUNT")
    private BigDecimal receiptAmount;

    /**
     * 发票号
     */
    @Column(name = "INVOICE_NUM")
    private String invoiceNum;


    /**
     * 本次核销金额
     */
    @Column(name = "APPLIED_AMOUNT")
    private BigDecimal appliedAmount=new BigDecimal(0.00);


    /**
     * 已核销金额
     */
    @Column(name = "APPLIED_AMOUNT_SUM")
    private BigDecimal appliedAmountSum;

    /**
     * 状态
     */
    @Column(name = "STATUS")
    private String status;




    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "PK_ID", foreignKey = @ForeignKey(name = "null"),insertable = false, unique = false, nullable = false, updatable = false)
    @Fetch(FetchMode.SELECT)
    @JsonIgnore
    @JSONField(serialize = false)
    private XhContractExecution xhContractExecution;


    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getContract_receivable_id() {
        return contract_receivable_id;
    }

    public void setContract_receivable_id(String contract_receivable_id) {
        this.contract_receivable_id = contract_receivable_id;
    }

    public Date getException_receipt_date() {
        return exception_receipt_date;
    }

    public void setException_receipt_date(Date exception_receipt_date) {
        this.exception_receipt_date = exception_receipt_date;
    }

    public String getExceptionReceiptPrecentage() {
        return exceptionReceiptPrecentage;
    }

    public void setExceptionReceiptPrecentage(String exceptionReceiptPrecentage) {
        this.exceptionReceiptPrecentage = exceptionReceiptPrecentage;
    }

    public BigDecimal getExceptionReceiptAmount() {
        return exceptionReceiptAmount;
    }

    public void setExceptionReceiptAmount(BigDecimal exceptionReceiptAmount) {
        this.exceptionReceiptAmount = exceptionReceiptAmount;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getReceiptInfoId() {
        return receiptInfoId;
    }

    public void setReceiptInfoId(String receiptInfoId) {
        this.receiptInfoId = receiptInfoId;
    }

    public Date getReceipt_date() {
        return receipt_date;
    }

    public void setReceipt_date(Date receipt_date) {
        this.receipt_date = receipt_date;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public BigDecimal getAppliedAmount() {
        return appliedAmount;
    }

    public void setAppliedAmount(BigDecimal appliedAmount) {
        this.appliedAmount = appliedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public XhContractExecution getXhContractExecution() {
        return xhContractExecution;
    }

    public void setXhContractExecution(XhContractExecution xhContractExecution) {
        this.xhContractExecution = xhContractExecution;
    }

    public BigDecimal getAppliedAmountSum() {
        return appliedAmountSum;
    }

    public void setAppliedAmountSum(BigDecimal appliedAmountSum) {
        this.appliedAmountSum = appliedAmountSum;
    }
}
