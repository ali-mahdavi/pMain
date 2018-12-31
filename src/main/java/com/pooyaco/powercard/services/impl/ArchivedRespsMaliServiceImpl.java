package com.pooyaco.powercard.services.impl;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.powercard.dao.ArchivedRepsMaliDao;
import com.pooyaco.powercard.entity.ArchivedRepsMali;
import com.pooyaco.powercard.models.ArchivedRepsMaliDto;
import com.pooyaco.powercard.services.ArchivedRespsMaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * Created by a.mahdavi on 9/10/2018.
 */
@Service
@Transactional
public class ArchivedRespsMaliServiceImpl extends BaseServiceImpl<ArchivedRepsMaliDto, ArchivedRepsMali, ArchivedRepsMaliDao> implements ArchivedRespsMaliService {
    @Autowired
    ArchivedRepsMaliDao archivedRepsMaliDao;

    public List<ArchivedRepsMali> findArchievedList(String reportName, String reportDate, String identifier) {
        try {
            return archivedRepsMaliDao.findArchievedList(reportName, reportDate, identifier);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateArchieved(String reportName, String reportDate, String identifier, String descNumber, String descDate) {
        return archivedRepsMaliDao.updateArchieved(reportName,
                reportDate,
                identifier,
                descNumber,
                descDate
        );
    }

}
