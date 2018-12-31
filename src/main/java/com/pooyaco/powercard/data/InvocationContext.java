/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooyaco.powercard.data;

import java.sql.CallableStatement;
import oracle.jdbc.OracleConnection;

/**
 *
 * @author Hossein
 */
public class InvocationContext {
    private OracleConnection conn;
    CallableStatement callableSt;

    public OracleConnection getConn() {
        return conn;
    }

    public void setConn(OracleConnection conn) {
        this.conn = conn;
    }

    public CallableStatement getCallableSt() {
        return callableSt;
    }

    public void setCallableSt(CallableStatement callableSt) {
        this.callableSt = callableSt;
    }
    
    
}
