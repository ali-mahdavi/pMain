package com.pooyaco.powercard.dao;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.powercard.entity.CutOfAmountAfter;
import com.pooyaco.powercard.models.CutOfAmountAfterDto;

import java.util.List;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
public interface CutOfAmountAfterDao extends BaseDao<CutOfAmountAfter> {
    List<CutOfAmountAfter> fetchAfterCutOf(String settlementDate, String terminalCode);
}
