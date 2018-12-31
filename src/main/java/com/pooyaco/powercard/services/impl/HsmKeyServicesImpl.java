package com.pooyaco.powercard.services.impl;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.powercard.dao.HsmKeyDao;
import com.pooyaco.powercard.entity.HsmKeyMember;
import com.pooyaco.powercard.models.HsmKeyMemberDto;
import com.pooyaco.powercard.services.HsmKeyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by a.mahdavi on 10/13/2018.
 */
@Service
public class HsmKeyServicesImpl extends BaseServiceImpl<HsmKeyMemberDto,HsmKeyMember,HsmKeyDao> implements HsmKeyServices {
    @Autowired
    HsmKeyDao hsmKeyDao;

    public String getHsmKey(String userName) {
        return hsmKeyDao.getHsmKey(userName);
    }
}
