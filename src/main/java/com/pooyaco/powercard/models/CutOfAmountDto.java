package com.pooyaco.powercard.models;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.dto.DtoComponent;
import com.pooyaco.gazelle.entity.BaseEntity;
import com.pooyaco.powercard.utility.CommonMethod;
import com.pooyaco.powercard.utility.JalaliCalendar;
import org.joda.time.DateTime;

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
@DtoComponent
public class CutOfAmountDto extends Dto {
    private String terminalNumber;
    private Integer  cutoffAmount;
    private String  branchCode;
    private String  groupingCode;
    private Date settlementDate;
    public CutOfAmountDto() {
    }
    @Override
    public Object getPK() {
        return null;
    }

    @Override
    public void setPK(Object o) {
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public Integer getCutoffAmount() {
        return cutoffAmount;
    }

    public void setCutoffAmount(Integer cutoffAmount) {
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

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {


        this.settlementDate = settlementDate;
    }
}
