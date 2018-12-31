package com.pooyaco.powercard.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pooyaco.gazelle.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
@Entity
@Table(name = "V_AFTER_CUTOFF_VIEW")
public class CutOfAmountAfter extends BaseEntity {
    @Id
    @Column(name="ROW_NUM")
    private String rowNum;

    @Column(name="branch_code")
    private String branchCode;

    @Column(name="terminal_atm_number")
    private String terminalNumber;

    @Column(name="settlement_date")
    private String settlementDate;

    @Column(name="TRN_AMOUNT_CURR1")
    private Integer  cutoffAmount;

    @Column(name="TRANSACTION_AMOUNT")
    private Integer  cutoffamountAfter;



    @Column(name="HOUR_CUTOFF")
    private String date;

    @Column(name="outlet_number")
    private String outletNumber;



    public CutOfAmountAfter() {
    }

    public String getDate() {
        return date;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public void setCutoffAmount(Integer cutoffAmount) {
        this.cutoffAmount = cutoffAmount;
    }

    public void setCutoffamountAfter(Integer cutoffamountAfter) {
        this.cutoffamountAfter = cutoffamountAfter;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getCutoffAmount() {
        return cutoffAmount;
    }

    public void setCutoffAmount(int cutoffAmount) {
        this.cutoffAmount = cutoffAmount;
    }

    public int getCutoffamountAfter() {
        return cutoffamountAfter;
    }

    public void setCutoffamountAfter(int cutoffamountAfter) {
        this.cutoffamountAfter = cutoffamountAfter;
    }



    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getOutletNumber() {
        return outletNumber;
    }

    public void setOutletNumber(String outletNumber) {
        this.outletNumber = outletNumber;
    }
}
