package com.pooyaco.powercard.services;

import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.powercard.models.ArchivedRepsSuspectDto;
import com.pooyaco.powercard.models.HsmKeyMemberDto;

/**
 * Created by a.mahdavi on 10/13/2018.
 */
public interface HsmKeyServices  extends BaseService<HsmKeyMemberDto>  {
    public String getHsmKey(String userName);
}
