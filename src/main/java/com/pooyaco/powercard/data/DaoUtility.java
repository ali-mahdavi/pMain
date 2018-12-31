/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooyaco.powercard.data;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.pooyaco.powercard.config.Constant;
import oracle.jdbc.OracleConnection;

/**
 *
 * @author Hossein
 */
public class DaoUtility {

    public static InvocationContext prepareConnection(String procedureCall) {
        InvocationContext ic = new InvocationContext();
        OracleConnection conn = null;
        javax.sql.DataSource ds = null;
        Hashtable env = new Hashtable();
        env.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(javax.naming.Context.PROVIDER_URL, "t3://"+Constant.Package_URL);

        javax.naming.Context context = null;
        try {
            context = new InitialContext(env);
            ds = (javax.sql.DataSource) context.lookup("jdbc/PowerDS");
        } catch (NamingException ex) {
            Logger.getLogger(DaoUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        CallableStatement callableSt = null;
        try {
            
            conn = (OracleConnection) ds.getConnection();
            callableSt = conn.prepareCall(procedureCall);
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ic.setConn(conn);
        ic.setCallableSt(callableSt);

        return ic;
    }
}
