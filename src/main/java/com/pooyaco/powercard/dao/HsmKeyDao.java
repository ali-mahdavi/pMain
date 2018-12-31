package com.pooyaco.powercard.dao;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.powercard.entity.HsmKeyMember;

/**
 * Created by a.mahdavi on 10/13/2018.
 */
public interface HsmKeyDao extends BaseDao<HsmKeyMember> {
    public String getHsmKey(String userName);
}
