package com.pooyaco.powercard.entity;

import com.pooyaco.gazelle.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by a.mahdavi on 10/13/2018.
 */
@Entity
@Table(name = "ws_users")
public class Users extends BaseEntity {
    @Id
    @Column(name = "USER_NAME")
    private  String userName;

    @Column(name = "SEQ_NUMBER")
    private  String seqNumber;

    public Users() {

    }

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
}
