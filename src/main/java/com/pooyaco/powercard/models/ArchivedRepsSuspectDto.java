package com.pooyaco.powercard.models;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.dto.DtoComponent;

/**
 * Created by a.mahdavi on 9/8/2018.
 */
@DtoComponent
public class ArchivedRepsSuspectDto extends Dto {


    private String reportName;

    private String effectiveDate;

    private String parameter_1;

    private String parameter_2;

    private String parameter_3;

    private String parameter_4;

    private String parameter_5;

    private String parameter_6;

    private String dateCreate;

    private String userCreate;

    private String dateModeif;

    private String userModif;


    private String reportDate;

    private String reportUser;

    private String checkFlag;
    ArchivedRepsSuspectDto(){

    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateModeif() {
        return dateModeif;
    }

    public void setDateModeif(String dateModeif) {
        this.dateModeif = dateModeif;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
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

    public String getParameter_3() {
        return parameter_3;
    }

    public void setParameter_3(String parameter_3) {
        this.parameter_3 = parameter_3;
    }

    public String getParameter_4() {
        return parameter_4;
    }

    public void setParameter_4(String parameter_4) {
        this.parameter_4 = parameter_4;
    }

    public String getParameter_5() {
        return parameter_5;
    }

    public void setParameter_5(String parameter_5) {
        this.parameter_5 = parameter_5;
    }

    public String getParameter_6() {
        return parameter_6;
    }

    public void setParameter_6(String parameter_6) {
        this.parameter_6 = parameter_6;
    }


    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }



    public String getUserModif() {
        return userModif;
    }

    public void setUserModif(String userModif) {
        this.userModif = userModif;
    }



    public String getReportUser() {
        return reportUser;
    }

    public void setReportUser(String reportUser) {
        this.reportUser = reportUser;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    @Override
    public Object getPK() {
        return null;
    }

    @Override
    public void setPK(Object o) {

    }
}