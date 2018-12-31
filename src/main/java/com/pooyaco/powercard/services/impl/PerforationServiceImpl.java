package com.pooyaco.powercard.services.impl;


import com.pooyaco.powercard.data.DaoUtility;
import com.pooyaco.powercard.data.InvocationContext;
import com.pooyaco.powercard.services.PerforationService;
import oracle.jdbc.OracleTypes;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * Created by a.mahdavi on 10/6/2018.
 */
@Service
public class PerforationServiceImpl implements PerforationService{

    @Transactional
    public String fetchPerf(String PosNumber) {

        JSONArray jsonArray = new JSONArray();
        try {
            InvocationContext ic = DaoUtility.prepareConnection("{? = call POOYA_MCDS_PERFORATION_TOOLS.FETCH_TRX_FOR_PERFORATION(?,?)}");
            CallableStatement callableSt = ic.getCallableSt();
            callableSt.registerOutParameter(1, OracleTypes.INTEGER);
            callableSt.setString(2, PosNumber);
            callableSt.registerOutParameter(3, OracleTypes.CURSOR);
            callableSt.executeUpdate();
            ResultSet t = (ResultSet) callableSt.getObject(3);
            while (t.next()) {
                JSONObject json = new JSONObject();
                json.put("CARD_ACCEPTOR_ID", t.getString(1));
                json.put("CARD_NUMBER", t.getString(2));
                json.put("INTERNAL_TRANSMISSION_TIME", t.getString(3));
                json.put("TRANSACTION_AMOUNT", t.getString(4));
                json.put("SOURCE_ACCOUNT_NUMBER", t.getString(5));
                json.put("PROCESSING_CODE", t.getString(6));
                json.put("INTERNAL_STAN", t.getString(7));
                json.put("CARD_ACCEPTOR_TERM_ID", t.getString(8));
                json.put("ROUTING_CODE", t.getString(9));
                json.put("ACTION_CODE", t.getString(10));
                json.put("EXTERNAL_STAN", t.getString(11));
                json.put("CURRENT_TABLE_INDICATOR", t.getString(12));
                json.put("RID", t.getString(13));
                jsonArray.put(jsonArray.length(), json);
            }
            ic.getConn().close();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return jsonArray.toString();
    }
    @Transactional
    public String updatePerf(String rowID, String tableIndicator) {
        JSONObject json = new JSONObject();
        try {
            InvocationContext ic = DaoUtility.prepareConnection("{? = call POOYA_MCDS_PERFORATION_TOOLS.UPDATE_TRX_FOR_PERFORATION(?,?)}");
            CallableStatement callableSt = ic.getCallableSt();
            callableSt.registerOutParameter(1, OracleTypes.INTEGER);
            callableSt.setString(2, rowID);
            callableSt.setString(3, tableIndicator);
            callableSt.executeUpdate();
            //ResultSet resSet = (ResultSet) callableSt.getObject(1);
            json.put("RESULT", callableSt.getInt(1));
            return json.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
