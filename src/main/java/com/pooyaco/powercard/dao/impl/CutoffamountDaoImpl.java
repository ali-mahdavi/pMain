package com.pooyaco.powercard.dao.impl;

import com.pooyaco.gazelle.da.impl.BaseDaoImpl;
import com.pooyaco.powercard.dao.CutOfAmountDao;
import com.pooyaco.powercard.entity.CutOfAmount;
import com.pooyaco.powercard.utility.CommonMethod;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
@Repository
public class CutoffamountDaoImpl extends BaseDaoImpl<CutOfAmount> implements CutOfAmountDao {
    private static Logger logger = LoggerFactory.getLogger(CutoffamountDaoImpl.class);
    private static final String TAG =CutoffamountDaoImpl.class.getSimpleName();
    @Override
    public List<CutOfAmount> fetchCutOfInfo(String settlementDate, String branchGroup, String collectionOfBranch) {
        try {
            String hql = "SELECT * FROM V_CUTOFF_VIEW \n" +
                    "WHERE  TO_CHAR(SETTLEMENT_DATE,'YYYY-MM-DD','NLS_CALENDAR=PERSIAN')=?1\n" +
                    "AND (GROUPING_CODE=?2 OR ?2 IS NULL)\n" +
                    "AND (BRANCH_CODE MEMBER OF SPLIT(?3) OR ?3 IS NULL)\n";
            List<CutOfAmount>  repsDtoList = getEntityManager()
                    .createNativeQuery(hql,CutOfAmount.class)
                    .setParameter(1, settlementDate)
                    .setParameter(2, branchGroup)
                    .setParameter(3, collectionOfBranch)
                    .getResultList();
            for(CutOfAmount c:repsDtoList){
                c.setSettlementDate(CommonMethod.DateToShamsi(c.getSettlementDate()));
                getEntityManager().detach(c);
            }
            return repsDtoList;
        }
        catch(Exception exp){
                logger.error(TAG,"Error:-" + exp.getMessage());
            exp.printStackTrace();
            return null;
        }
    }
}
