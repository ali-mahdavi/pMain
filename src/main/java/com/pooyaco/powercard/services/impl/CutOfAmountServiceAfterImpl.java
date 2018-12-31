package com.pooyaco.powercard.services.impl;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.powercard.dao.CutOfAmountAfterDao;
import com.pooyaco.powercard.dao.CutOfAmountDao;
import com.pooyaco.powercard.entity.CutOfAmount;
import com.pooyaco.powercard.entity.CutOfAmountAfter;
import com.pooyaco.powercard.models.CutOfAmountAfterDto;
import com.pooyaco.powercard.models.CutOfAmountDto;
import com.pooyaco.powercard.services.CutOfAmountService;
import com.pooyaco.powercard.services.CutOffAmountAfterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
@Service
public class CutOfAmountServiceAfterImpl extends BaseServiceImpl<CutOfAmountAfterDto, CutOfAmountAfter, CutOfAmountAfterDao> implements CutOffAmountAfterService {
    @Autowired
    CutOfAmountAfterDao cutoffAmountAfterDao;

    @Override
    @Transactional
    public List<CutOfAmountAfter> fetchAfterCutOf(String settlementDate, String terminalCode) {
        return cutoffAmountAfterDao.fetchAfterCutOf(settlementDate,terminalCode);
    }
}
