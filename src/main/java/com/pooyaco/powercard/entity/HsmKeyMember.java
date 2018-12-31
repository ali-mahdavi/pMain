package com.pooyaco.powercard.entity;

import com.pooyaco.gazelle.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by a.mahdavi on 10/11/2018.
 */
@Entity
@Table(name = "hsm_key_member")
public class HsmKeyMember extends BaseEntity {
    @Id
    @Column(name="KEY_CODE")
    private  String keyCode;

    @Column(name = "BANK_CODE")
    private String bankCode;


    @Column(name = "SEQ_NUMBER")
    private String sequenceNumber;

    @Column(name = "KEY1_VALUE")
    private String Key;

    public HsmKeyMember() {
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
