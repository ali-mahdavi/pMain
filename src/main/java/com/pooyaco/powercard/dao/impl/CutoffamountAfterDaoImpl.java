package com.pooyaco.powercard.dao.impl;
import com.pooyaco.gazelle.da.impl.BaseDaoImpl;
import com.pooyaco.powercard.dao.CutOfAmountAfterDao;
import com.pooyaco.powercard.entity.CutOfAmount;
import com.pooyaco.powercard.entity.CutOfAmountAfter;
import com.pooyaco.powercard.models.CutOfAmountAfterDto;
import com.pooyaco.powercard.utility.CommonMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by a.mahdavi on 11/5/2018.
 */
@Repository
public class CutoffamountAfterDaoImpl extends BaseDaoImpl<CutOfAmountAfter> implements CutOfAmountAfterDao {
    private static Logger logger = LoggerFactory.getLogger(CutoffamountAfterDaoImpl.class);
    private static final String TAG =CutoffamountAfterDaoImpl.class.getSimpleName();
    @Override
    public List<CutOfAmountAfter> fetchAfterCutOf(String settlementDate, String terminalCode) {
        try {
            List<CutOfAmountAfter> repsDtoList=new ArrayList<>();

            if(terminalCode!=null&&terminalCode.length()>0){
                String q = "FROM CutOfAmountAfter a \n" +
                        "WHERE  TO_CHAR(a.settlementDate,'YYYY-MM-DD','nls_calendar=persian')= ?1 \n" +
                        "AND\n" +
                        "a.terminalNumber=?2\n";
                repsDtoList = getEntityManager()
                        .createQuery(q)
                        .setParameter(1, settlementDate)
                        .setParameter(2, terminalCode)
                        .getResultList();

            }else{
                String q = "FROM CutOfAmountAfter a \n" +
                        "WHERE  TO_CHAR(a.settlementDate,'YYYY-MM-DD','nls_calendar=persian')= ?1";

                 repsDtoList = getEntityManager()
                        .createQuery(q)
                        .setParameter(1, settlementDate)
                        .getResultList();
            }

            for(CutOfAmountAfter c:repsDtoList){
                c.setSettlementDate(CommonMethod.DateToShamsi(c.getSettlementDate()));
                c.setDate(CommonMethod.DateToShamsi(c.getDate()));
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
