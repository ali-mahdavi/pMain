package com.pooyaco.powercard.services.impl;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.powercard.dao.ArchivedRepsDao;
import com.pooyaco.powercard.entity.ArchivedReps;
import com.pooyaco.powercard.models.ArchivedRepsDto;
import com.pooyaco.powercard.services.ArchivedRespsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * Created by a.mahdavi on 9/10/2018.
 */
@Service
public class ArchivedRespsServiceImpl extends BaseServiceImpl<ArchivedRepsDto,ArchivedReps,ArchivedRepsDao> implements ArchivedRespsService {
    @Autowired
    ArchivedRepsDao archivedRespsDao;


    @Transactional
    public List<ArchivedReps> findArchievedList(String reportName, String reportDate) {
        try {
            return archivedRespsDao.findArchievedList(reportName,reportDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Transactional
    public boolean updateArchieved(String reportName, String reportDate, String descNumber, String descDate) {
        return archivedRespsDao.updateArchieved(reportName,
                                              reportDate,
                                            descNumber,
                                            descDate );
    }



}
