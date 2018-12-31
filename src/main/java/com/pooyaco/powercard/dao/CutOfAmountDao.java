package com.pooyaco.powercard.dao;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.powercard.entity.CutOfAmount;
import com.pooyaco.powercard.models.CutOfAmountDto;

import java.util.List;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
public interface CutOfAmountDao extends BaseDao<CutOfAmount> {
    List<CutOfAmount> fetchCutOfInfo(String settlementDate, String branchGroup, String collectionOfBranch);
}
