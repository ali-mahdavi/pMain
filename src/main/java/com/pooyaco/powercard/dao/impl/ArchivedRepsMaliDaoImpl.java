package com.pooyaco.powercard.dao.impl;

import com.pooyaco.gazelle.da.impl.BaseDaoImpl;
import com.pooyaco.powercard.dao.ArchivedRepsMaliDao;
import com.pooyaco.powercard.entity.ArchivedRepsMali;
import com.pooyaco.powercard.utility.CommonMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

/**
 * Created by a.mahdavi on 9/9/2018.
 */
@Repository
public class ArchivedRepsMaliDaoImpl extends BaseDaoImpl<ArchivedRepsMali> implements ArchivedRepsMaliDao {

    private static Logger logger = LoggerFactory.getLogger(ArchivedRepsMaliDaoImpl.class);
    private static final String TAG =CutoffamountDaoImpl.class.getSimpleName();
    @Override
    public List<ArchivedRepsMali> findArchievedList(String reportName, String reportDate, String identifier) throws ParseException {
        List<ArchivedRepsMali> archivedRepsMaliDtos;
        String q;
        if (identifier != null && !identifier.isEmpty()) {
            q = "from ArchivedRepsMali a where " +
                    "a.reportName=\'" + reportName + "\' and a.identifier=\'" + identifier + "\' and " +
                    "TRUNC(a.effectiveDate)=TO_DATE(\'" + reportDate + "\','YYYY-MM-DD','nls_calendar=persian')";
        } else {
            q = "from ArchivedRepsMali a where " +
                    "a.reportName=\'" + reportName + "\' and " +
                    "TRUNC(a.effectiveDate)=TO_DATE(\'" + reportDate + "\','YYYY-MM-DD','nls_calendar=persian')";
        }
        archivedRepsMaliDtos = getEntityManager().createQuery(q).getResultList();
        for (ArchivedRepsMali c : archivedRepsMaliDtos) {
            c.setReportDate(CommonMethod.DateToShamsi(c.getReportDate()));
            c.setDateCreate(CommonMethod.DateToShamsi(c.getDateCreate()));
            c.setDateModif(CommonMethod.DateToShamsi(c.getDateModif()));
            c.setEffectiveDate(CommonMethod.DateToShamsi(c.getEffectiveDate()));
            c.setDescDate(CommonMethod.DateToShamsi(c.getDescDate()));
            getEntityManager().detach(c);
        }
        return archivedRepsMaliDtos;
    }

    @Override
    public boolean updateArchieved(String reportName,
                                   String reportDate,
                                   String identifier,
                                   String descNumber,
                                   String descDate) {
        try {
            String  q;
            int  m=0;
            if (identifier != null&& identifier.length()>0 ) {
            q="UPDATE ArchivedRepsMali as a SET descNumber =?1," +
                    " descDate = TO_DATE(?2,'YYYY-MM-DD','nls_calendar=persian') WHERE" +
                    " reportName=?3 AND" +
                    " identifier=?4 AND" +
                    " TRUNC(effectiveDate) =TO_CHAR(TO_DATE(?5,'YYYY-MM-DD','nls_calendar=persian'))";
            m = getEntityManager().createQuery(q)
                    .setParameter(1, descNumber)
                    .setParameter(2, descDate)
                    .setParameter(3, reportName)
                    .setParameter(4, identifier)
                    .setParameter(5, reportDate)
                    .executeUpdate();

            } else {
                q="UPDATE ArchivedRepsMali SET descNumber =?1," +
                        " descDate =TO_DATE(?2,'YYYY-MM-DD','nls_calendar=persian') WHERE" +
                        " reportName=?3 AND" +
                        " TRUNC(effectiveDate) =TO_CHAR(TO_DATE(?4,'YYYY-MM-DD','nls_calendar=persian'))";
                m = getEntityManager().createQuery(q)
                        .setParameter(1, descNumber)
                        .setParameter(2, descDate)
                        .setParameter(3, reportName)
                        .setParameter(4, reportDate)
                        .executeUpdate();
            }
            flush();
            if (m > 0)
                return true;
            else
                return false;
        } catch (Exception exp) {
            exp.printStackTrace();
            logger.error(TAG,"Error:-" + exp.getMessage());
            return false;
        }
    }



}
