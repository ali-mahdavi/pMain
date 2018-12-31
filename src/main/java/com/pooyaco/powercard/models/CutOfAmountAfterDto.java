package com.pooyaco.powercard.models;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.dto.DtoComponent;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
@DtoComponent
public class CutOfAmountAfterDto extends Dto {
    private String branchCode;
    private String terminalNumber;
    private Date settlementDate;

    private Integer  cutoffAmount;


    private Integer  cutoffamountAfter;

    private Date date;
    private String outletNumber;
    @Override
    public Object getPK() {
        return null;
    }
    @Override
    public void setPK(Object o) {
    }
    public CutOfAmountAfterDto() {

    }
    public String getBranchCode() {
        return branchCode;
    }
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    public String getTerminalNumber() {
        return terminalNumber;
    }
    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }
    public Date getSettlementDate() {
        return settlementDate;
    }
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getOutletNumber() {
        return outletNumber;
    }
    public void setOutletNumber(String outletNumber) {
        this.outletNumber = outletNumber;
    }


    public Integer getCutoffAmount() {
        return cutoffAmount;
    }

    public void setCutoffAmount(Integer cutoffAmount) {
        this.cutoffAmount = cutoffAmount;
    }

    public Integer getCutoffamountAfter() {
        return cutoffamountAfter;
    }

    public void setCutoffamountAfter(Integer cutoffamountAfter) {
        this.cutoffamountAfter = cutoffamountAfter;
    }
}
