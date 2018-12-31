package com.pooyaco.powercard.models;

/**
 * Created by a.mahdavi on 10/4/2018.
 */
public class PerferajErrorDto {
    private String errorCode;
    private String errorDesc;
    public PerferajErrorDto() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
}
