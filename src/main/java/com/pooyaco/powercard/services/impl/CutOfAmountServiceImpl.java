package com.pooyaco.powercard.services.impl;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.powercard.dao.CutOfAmountDao;
import com.pooyaco.powercard.entity.CutOfAmount;
import com.pooyaco.powercard.models.CutOfAmountDto;
import com.pooyaco.powercard.services.CutOfAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by a.mahdavi on 11/5/2018.
 */
@Service
public class CutOfAmountServiceImpl extends BaseServiceImpl<CutOfAmountDto, CutOfAmount, CutOfAmountDao> implements CutOfAmountService {
    @Autowired
    CutOfAmountDao cutoffamountDao;
    @Override
    @Transactional
    public List<CutOfAmount> fetchCutOfInfo(String settlementDate, String branchGroup, String collectionOfBranch) {
        return cutoffamountDao.fetchCutOfInfo(settlementDate,branchGroup,collectionOfBranch);
    }
}
