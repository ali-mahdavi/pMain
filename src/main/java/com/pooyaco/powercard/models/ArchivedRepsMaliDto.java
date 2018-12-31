package com.pooyaco.powercard.models;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.dto.DtoComponent;

/**
 * Created by a.mahdavi on 9/8/2018.
 */
@DtoComponent
public class ArchivedRepsMaliDto extends Dto {


    private String reportName;

    private String effectiveDate;

    private String parameter_1;

    private String parameter_2;

    private long totalNo;

    private long totalAmount;

    private String identifier;

    private String descNumber;

    private String descDate;

    private String dateCreate;

    private String userCreate;


    private String dateModif;

    private String userModif;

    private String reportDate;

    private String reportUser;

    private String checkFlag;



    ArchivedRepsMaliDto(){

    }



    public String getUserModif() {
        return userModif;
    }

    public void setUserModif(String userModif) {
        this.userModif = userModif;
    }

    public String getReportName() {
        return reportName;
    }
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {

        this.effectiveDate = effectiveDate;
    }

    public String getParameter_1() {
        return parameter_1;
    }

    public void setParameter_1(String parameter_1) {
        this.parameter_1 = parameter_1;
    }

    public String getParameter_2() {
        return parameter_2;
    }

    public void setParameter_2(String parameter_2) {
        this.parameter_2 = parameter_2;
    }

    public long getTotalNo() {
        return totalNo;
    }

    public void setTotalNo(long totalNo) {
        this.totalNo = totalNo;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }



    public String getDescNumber() {
        return descNumber;
    }

    public void setDescNumber(String descNumber) {
        this.descNumber = descNumber;
    }



    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getDescDate() {
        return descDate;
    }

    public void setDescDate(String descDate) {
        this.descDate = descDate;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateModif() {
        return dateModif;
    }

    public void setDateModif(String dateModif) {
        this.dateModif = dateModif;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportUser() {
        return reportUser;
    }

    public void setReportUser(String reportUser) {
        this.reportUser = reportUser;
    }

    @Override
    public Object getPK() {
        return null;
    }

    @Override
    public void setPK(Object o) {

    }
}
