package com.pooyaco.powercard.services;

import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.powercard.entity.CutOfAmountAfter;
import com.pooyaco.powercard.models.CutOfAmountAfterDto;

import java.util.List;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
public interface CutOffAmountAfterService extends BaseService<CutOfAmountAfterDto> {
   List<CutOfAmountAfter> fetchAfterCutOf(String settlementDate, String terminalCode);
}
