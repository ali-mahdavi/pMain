package com.pooyaco.powercard.services;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.powercard.entity.ArchivedRepsMali;
import com.pooyaco.powercard.models.ArchivedRepsDto;
import com.pooyaco.powercard.models.ArchivedRepsMaliDto;
import com.pooyaco.powercard.models.ArchivedRepsSuspectDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by a.mahdavi on 9/9/2018.
 */

public interface ArchivedRespsMaliService extends BaseService<ArchivedRepsMaliDto> {
    List<ArchivedRepsMali> findArchievedList(String reportName, String reportDate, String identifier);

    boolean updateArchieved(String reportName,
                            String reportDate,
                            String identifier,
                            String descNumber,
                            String descDate);


}
