package com.pooyaco.powercard.services;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.powercard.entity.ArchivedReps;
import com.pooyaco.powercard.models.ArchivedRepsDto;
import com.pooyaco.powercard.models.ArchivedRepsSuspectDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by a.mahdavi on 9/9/2018.
 */

public interface ArchivedRespsService extends BaseService<ArchivedRepsDto>{
    List<ArchivedReps> findArchievedList(String reportName, String reportDate);

    boolean updateArchieved(String reportName, String reportDate, String descNumber, String descDate);


}
