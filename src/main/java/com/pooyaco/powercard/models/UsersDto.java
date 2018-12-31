package com.pooyaco.powercard.models;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.dto.DtoComponent;

/**
 * Created by a.mahdavi on 10/13/2018.
 */
@DtoComponent
public class UsersDto   extends Dto {
    private  String userName;
    private  String seqNumber;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }
    @Override
    public Object getPK() {
        return null;
    }

    @Override
    public void setPK(Object o) {

    }
}
