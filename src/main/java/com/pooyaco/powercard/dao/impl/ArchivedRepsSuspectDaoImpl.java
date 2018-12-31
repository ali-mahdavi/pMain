package com.pooyaco.powercard.dao.impl;

import com.pooyaco.gazelle.da.impl.BaseDaoImpl;
import com.pooyaco.powercard.dao.ArchivedRepsSuspectDao;
import com.pooyaco.powercard.entity.ArchivedRepsSuspect;
import com.pooyaco.powercard.utility.CommonMethod;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

/**
 * Created by a.mahdavi on 9/9/2018.
 */
@Repository
public class ArchivedRepsSuspectDaoImpl extends BaseDaoImpl<ArchivedRepsSuspect> implements ArchivedRepsSuspectDao {

    @Override
    public List<ArchivedRepsSuspect> findArchievedList(String reportName, String reportDate) throws ParseException {
        String q = "from ArchivedRepsSuspect a where " +
                "a.reportName=\'" + reportName + "\' and " +
                "TRUNC(a.effectiveDate)=TO_DATE(\'" + reportDate + "\','YYYY-MM-DD','nls_calendar=persian')";
        List<ArchivedRepsSuspect> repsDtoList = getEntityManager().createQuery(q).getResultList();
        for (ArchivedRepsSuspect c : repsDtoList) {
            c.setReportDate(CommonMethod.DateToShamsi(c.getReportDate()));
            c.setDateCreate(CommonMethod.DateToShamsi(c.getDateCreate()));
            c.setEffectiveDate(CommonMethod.DateToShamsi(c.getEffectiveDate()));
            c.setDateModif(CommonMethod.DateToShamsi(c.getDateModif()));
            getEntityManager().detach(c);
        }
        return repsDtoList;
    }
    @Override
    public boolean updateArchieved(String reportName, String reportDate, String descNumber, String descDate) {

        try {

            String q="UPDATE ArchivedRepsSuspect SET descNumber =?1," +
                    " descDate =TO_DATE(?2,'YYYY-MM-DD','nls_calendar=persian') WHERE" +
                    " reportName=?3 AND" +
                    " TRUNC(effectiveDate) =TO_CHAR(TO_DATE(?4,'YYYY-MM-DD','nls_calendar=persian'))";
            int  m = getEntityManager().createQuery(q)
                    .setParameter(1, descNumber)
                    .setParameter(2, descDate)
                    .setParameter(3, reportName)
                    .setParameter(4, reportDate)
                    .executeUpdate();
            if (m > 0)
                return true;
            else
                return false;
        } catch (Exception exp) {
            return false;
        }
    }



}
