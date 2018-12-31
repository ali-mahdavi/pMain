package com.pooyaco.powercard.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pooyaco.gazelle.entity.BaseEntity;
import com.pooyaco.powercard.utility.CommonMethod;
import com.pooyaco.powercard.utility.JalaliCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
@Entity
@Table(name = "V_CUTOFF_VIEW")
public class CutOfAmount extends BaseEntity {
    @Id
    @Column(name="ROW_NUM")
    private String rowNum;
    @Column(name="TERMINAL_NUMBER")
    private String terminalNumber;
    @Column(name="TRN_AMOUNT_CURR1")
    private String  cutoffAmount;

    @Column(name="BRANCH_CODE")
    private String  branchCode;

    @Column(name="GROUPING_CODE")
    private String  groupingCode;

    @Column(name="SETTLEMENT_DATE")
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    private String settlementDate;

    public CutOfAmount() {
        cutoffAmount="";
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public String getCutoffAmount() {
        return cutoffAmount;
    }

    public void setCutoffAmount(String cutoffAmount) {
        this.cutoffAmount = cutoffAmount;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getGroupingCode() {
        return groupingCode;
    }

    public void setGroupingCode(String groupingCode) {
        this.groupingCode = groupingCode;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {


        this.settlementDate = settlementDate;
    }
}
