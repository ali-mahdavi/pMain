package com.pooyaco.powercard.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pooyaco.gazelle.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by a.mahdavi on 9/8/2018.
 */
@Entity
@Table(name = "archived_reps_mali")
public class ArchivedRepsMali extends BaseEntity {

    @Id
    @SequenceGenerator(name = "archived_reps_ma_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "archived_reps_ma_seq")
    private long id;

    @Column(name = "REPORT_NAME")
    private String reportName;
    @Column(name = "EFFECTIVE_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    private String effectiveDate;
    @Column(name = "PARAMETER_1")
    private String parameter_1;
    @Column(name = "PARAMETER_2")
    private String parameter_2;
    @Column(name = "TOTAL_NO")
    private long totalNo;
    @Column(name = "TOTAL_AMOUNT")
    private long totalAmount;
    @Column(name = "IDENTIFIER")
    private String identifier;
    @Column(name = "DESC_NUMBER")
    private String descNumber;
    @Column(name = "DESC_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    private String descDate;
    @Column(name = "DATE_CREATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    private String dateCreate;
    @Column(name = "USER_CREATE")
    private String userCreate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    @Column(name = "DATE_MODIF")
    private String dateModif;
    @Column(name = "USER_MODIF")
    private String userModif;
    @Column(name = "REPORT_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    private String reportDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH24:MI:SS")
    @Column(name = "REPORT_USER")
    private String reportUser;
    @Column(name = "CHECK_FLAG")
    private String checkFlag;

    ArchivedRepsMali() {

    }


    public String getUserModif() {
        return userModif;
    }

    public void setUserModif(String userModif) {
        this.userModif = userModif;
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

        this.effectiveDate =effectiveDate;
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
}
