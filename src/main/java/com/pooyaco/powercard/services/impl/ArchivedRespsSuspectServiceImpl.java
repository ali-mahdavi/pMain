package com.pooyaco.powercard.services.impl;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.powercard.dao.ArchivedRepsSuspectDao;
import com.pooyaco.powercard.entity.ArchivedRepsSuspect;
import com.pooyaco.powercard.models.ArchivedRepsSuspectDto;
import com.pooyaco.powercard.services.ArchivedRespsSuspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * Created by a.mahdavi on 9/10/2018.
 */
@Service
public class ArchivedRespsSuspectServiceImpl extends BaseServiceImpl<ArchivedRepsSuspectDto,ArchivedRepsSuspect,ArchivedRepsSuspectDao> implements ArchivedRespsSuspectService {
    @Autowired
    ArchivedRepsSuspectDao archivedRespsSuspectDao;

    @Transactional
    public List<ArchivedRepsSuspect> findArchievedList(String reportName, String reportDate) {
        try {
            return archivedRespsSuspectDao.findArchievedList(reportName,reportDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Transactional
    public boolean updateArchieved(String reportName,
                                 String reportDate,
                                 String descNumber,
                                 String descDate) {
        return archivedRespsSuspectDao.updateArchieved(reportName,
                                              reportDate,
                                                descNumber,
                                                descDate
                                              );
    }



}
