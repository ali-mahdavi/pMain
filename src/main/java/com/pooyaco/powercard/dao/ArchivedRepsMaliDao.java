package com.pooyaco.powercard.dao;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.powercard.entity.ArchivedRepsMali;
import com.pooyaco.powercard.models.ArchivedRepsDto;
import com.pooyaco.powercard.models.ArchivedRepsMaliDto;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by a.mahdavi on 9/9/2018.
 */
public interface ArchivedRepsMaliDao extends BaseDao<ArchivedRepsMali> {
 List<ArchivedRepsMali> findArchievedList(String reportName, String reportDate, String identifier) throws ParseException;

 boolean updateArchieved(String reportName, String reportDate, String identifier, String descNumber, String descDate);



}
