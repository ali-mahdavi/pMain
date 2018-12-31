package com.pooyaco.powercard.services;

import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.powercard.entity.ArchivedRepsSuspect;
import com.pooyaco.powercard.models.ArchivedRepsSuspectDto;

import java.util.List;

/**
 * Created by a.mahdavi on 9/9/2018.
 */

public interface ArchivedRespsSuspectService  extends BaseService<ArchivedRepsSuspectDto> {
    List<ArchivedRepsSuspect> findArchievedList(String reportName, String reportDate);

    boolean updateArchieved(String reportName, String reportDate, String descNumber, String descDate);



}
