package com.pooyaco.powercard.models;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.dto.DtoComponent;

import javax.persistence.*;

/**
 * Created by a.mahdavi on 10/11/2018.
 */
@DtoComponent
public class HsmKeyMemberDto extends Dto {


    private String bankCode;
    private String sequenceNumber;
    private String Key;

    public HsmKeyMemberDto() {
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

    @Override
    public Object getPK() {
        return null;
    }

    @Override
    public void setPK(Object o) {

    }
}
