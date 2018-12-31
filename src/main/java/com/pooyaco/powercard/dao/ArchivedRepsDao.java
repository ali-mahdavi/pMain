package com.pooyaco.powercard.dao;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.powercard.entity.ArchivedReps;
import com.pooyaco.powercard.models.ArchivedRepsDto;

import java.text.ParseException;
import java.util.List;

/**
 * Created by a.mahdavi on 9/9/2018.
 */

public interface ArchivedRepsDao extends BaseDao<ArchivedReps> {
    List<ArchivedReps> findArchievedList(String reportName, String reportDate) throws ParseException;
    boolean updateArchieved(String reportName, String reportDate, String descNumber, String descDate);


}
