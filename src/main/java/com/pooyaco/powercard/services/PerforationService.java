package com.pooyaco.powercard.services;

/**
 * Created by a.mahdavi on 10/6/2018.
 */
public interface PerforationService {
    public String fetchPerf(String PosNumber);
    public String updatePerf(String rowID,String tableIndicator);
}
