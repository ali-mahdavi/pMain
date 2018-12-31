package com.pooyaco.powercard.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pooyaco.gazelle.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by a.mahdavi on 9/8/2018.
 */
@Entity
@Table(name = "archived_reps")
public class ArchivedReps extends BaseEntity {
    @Id
    @SequenceGenerator(name = "archived_reps_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "archived_reps_seq")
    private long id;
    @Column(name = "REPORT_NAME")
    private String reportName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    @Column(name = "EFFECTIVE_DATE")
    private String effectiveDate;
    @Column(name = "PARAMETER_1")
    private String parameter_1;
    @Column(name = "PARAMETER_2")
    private String parameter_2;
    @Column(name = "PARAMETER_3")
    private String parameter_3;
    @Column(name = "PARAMETER_4")
    private String parameter_4;
    @Column(name = "PARAMETER_5")
    private String parameter_5;
    @Column(name = "PARAMETER_6")
    private String parameter_6;
    @Column(name = "DATE_CREATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    private String dateCreate;
    @Column(name = "USER_CREATE")
    private String userCreate;
    @Column(name = "DATE_MODIF")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dateModif;
    @Column(name = "USER_MODIF")
    private String userModif;
    @Column(name = "REPORT_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String reportDate;
    @Column(name = "REPORT_USER")
    private String reportUser;
    @Column(name = "CHECK_FLAG")
    private String checkFlag;

    ArchivedReps(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getDateModif() {
        return dateModif;
    }

    public void setDateModif(String dateModif) {
        this.dateModif = dateModif;
    }

    public String getUserModif() {
        return userModif;
    }

    public void setUserModif(String userModif) {
        this.userModif = userModif;
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

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }
}
