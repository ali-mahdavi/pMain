package com.pooyaco.powercard.services;

import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.powercard.entity.CutOfAmount;
import com.pooyaco.powercard.models.CutOfAmountDto;

import java.util.List;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
public interface CutOfAmountService extends BaseService<CutOfAmountDto> {
   List<CutOfAmount> fetchCutOfInfo(String settlementDate, String branchGroup, String collectionOfBranch);
}
