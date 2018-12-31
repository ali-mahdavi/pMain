package com.pooyaco.powercard.dao.impl;

import com.pooyaco.gazelle.da.impl.BaseDaoImpl;
import com.pooyaco.powercard.dao.HsmKeyDao;
import com.pooyaco.powercard.entity.HsmKeyMember;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by a.mahdavi on 10/13/2018.
 */
@Repository
public class HsmKeyDaoImpl extends BaseDaoImpl<HsmKeyMember> implements HsmKeyDao {


    public String getHsmKey(String userName) {
        String sqlQuery = "select hsm_key_member.KEY1_VALUE from hsm_key_member  where " +
                "hsm_key_member.BANK_CODE = '000014' and " +
                "hsm_key_member.KEY_CODE='WBS' and  " +
                "hsm_key_member.SEQ_NUMBER IN (SELECT ws_users.SEQ_NUMBER from ws_users  WHERE ws_users.USER_NAME=?1)";

        Query query = getEntityManager().createNativeQuery(sqlQuery)
                  .setParameter(1,userName);
        List results = query.getResultList();
        String HsmKey="";
        if(!results.isEmpty()){
            // ignores multiple results
            HsmKey = (String) results.get(0);
        }
        return HsmKey;
    }
}
