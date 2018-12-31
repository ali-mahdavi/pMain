package com.pooyaco.powercard.controllers;

import com.pooyaco.powercard.common.Enums;
import com.pooyaco.powercard.entity.CutOfAmount;
import com.pooyaco.powercard.entity.CutOfAmountAfter;
import com.pooyaco.powercard.services.*;
import com.pooyaco.powercard.utility.CommonMethod;
import com.pooyaco.powercard.utility.ValidatorClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {
    private static Logger logger = LoggerFactory.getLogger(ApiRestController.class);
    private static final String TAG = ApiRestController.class.getSimpleName();
    @Autowired
    PerforationService perforationService;

    @Autowired
    ArchivedRespsService archivedRepsService;

    @Autowired
    ArchivedRespsSuspectService archivedRepSuspectService;

    @Autowired
    ArchivedRespsMaliService archivedRespsMaliService;

    @Autowired
    CutOfAmountService cutoffamountService;

    @Autowired
    CutOffAmountAfterService cutoffamountServiceAfter;


    @RequestMapping(value = "/archives", method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json; charset=UTF-8")
    public <T> ResponseEntity<List<T>> getArchieved(@RequestParam(value = "reportName") String reportName,
                                                    @RequestParam(value = "reportDate") String reportDate,
                                                    @RequestParam(value = "identifier", required = false) String identifier) {
        if (ValidatorClass.validateGetArchieved(reportName, reportDate, identifier)) {
            return new ResponseEntity(ValidatorClass.result.toString(), HttpStatus.BAD_REQUEST);
        } else {
            try {
                List<T> archivedReps = null;
                if (reportName.equals(Enums.Report01) || reportName.equals(Enums.Report02) || reportName.equals(Enums.Report03) || reportName.equals(Enums.Report04) || reportName.equals(Enums.Report05) || reportName.equals(Enums.Report06) || reportName.equals(Enums.Report07) || reportName.equals(Enums.Report0801) || reportName.equals(Enums.Report09) || reportName.equals(Enums.Report10)) {
                    archivedReps = (List<T>) archivedRespsMaliService.findArchievedList(reportName, reportDate, identifier);

                } else if (reportName.equals(Enums.Report0802)) {
                    archivedReps = (List<T>) archivedRepSuspectService.findArchievedList(reportName, reportDate);

                } else if (reportName.equals(Enums.Report11) || reportName.equals(Enums.Report12) || reportName.equals(Enums.Report13) || reportName.equals(Enums.Report14) || reportName.equals(Enums.Report15)) {
                    archivedReps = (List<T>) archivedRepsService.findArchievedList(reportName, reportDate);

                }
                if(archivedReps!=null&& archivedReps.size()>0) {
                    return  new ResponseEntity((List<T>)archivedReps, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity(CommonMethod.NotFoundMessage(), HttpStatus.NOT_FOUND);
                }
            } catch (Exception exp) {
                exp.printStackTrace();
                logger.error(TAG, "Error:-" + exp.getMessage());
                return new ResponseEntity(CommonMethod.GeneralErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/archives",
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json; charset=UTF-8")
    public ResponseEntity<String> updateArchieved(
            @RequestParam(value = "reportName") String reportName,
            @RequestParam(value = "reportDate") String reportDate,
            @RequestParam(value = "identifier", required = false) String identifier,
            @RequestParam(value = "descNumber") String descNumber,
            @RequestParam(value = "descDate") String descDate
    ) {
        if (ValidatorClass.validateUpdateArchieved(reportName, reportDate, identifier, descNumber, descDate)) {
            return new ResponseEntity(ValidatorClass.result.toString(), HttpStatus.BAD_REQUEST);
        } else {

            boolean retFlage = false;
            try {

                if (reportName.equals(Enums.Report01) || reportName.equals(Enums.Report02) || reportName.equals(Enums.Report03) || reportName.equals(Enums.Report04) || reportName.equals(Enums.Report05) || reportName.equals(Enums.Report06) || reportName.equals(Enums.Report07) || reportName.equals(Enums.Report0801) || reportName.equals(Enums.Report09) || reportName.equals(Enums.Report10)) {
                    retFlage = archivedRespsMaliService.updateArchieved(reportName,
                            reportDate,
                            identifier,
                            descNumber,
                            descDate);


                } else if (reportName.equals(Enums.Report0802)) {
                    retFlage = archivedRepSuspectService.updateArchieved(reportName, reportDate,
                            descNumber,
                            descDate);

                } else if (reportName.equals(Enums.Report11) || reportName.equals(Enums.Report12) || reportName.equals(Enums.Report13) || reportName.equals(Enums.Report14) || reportName.equals(Enums.Report15)) {
                    retFlage = archivedRepsService.updateArchieved(reportName, reportDate,
                            descNumber,
                            descDate);
                }
            } catch (Exception exp) {
                logger.error(TAG, "Error:-" + exp.getMessage());
                exp.printStackTrace();
                return new ResponseEntity(CommonMethod.GeneralErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            } finally {
                if (retFlage) {
                    return new ResponseEntity<String>(CommonMethod.ResultUpdateMessage(true), HttpStatus.OK);
                } else {
                    return new ResponseEntity<String>(CommonMethod.ResultUpdateMessage(false), HttpStatus.NOT_FOUND);
                }
            }
        }
    }
    @RequestMapping(value = "/perforation", method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json; charset=UTF-8")
    public ResponseEntity<String> fetchPerf(@RequestParam(value = "PosNumber") String PosNumber) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        logger.info(TAG, "perforation: " + name);
        try {

            return new ResponseEntity(perforationService.fetchPerf(PosNumber), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(TAG, "Error:-" + ex.getMessage());
            return new ResponseEntity(CommonMethod.GeneralErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/perforation",
            method = RequestMethod.PUT,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json; charset=UTF-8")
    public ResponseEntity<String> updatePerf(@RequestParam(value = "RowID") String rowID,
                                             @RequestParam(value = "TableIndicator") String tableIndicator
    ) {
        try {
            return new ResponseEntity(perforationService.updatePerf(rowID, tableIndicator), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(TAG, "Error:-" + ex.getMessage());
            return new ResponseEntity(CommonMethod.GeneralErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/cutOffAmountInfo",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity fetchCutOffInfo(@RequestParam(value = "settlementDate") String settlementDate,
                                          @RequestParam(value = "branchGroup", required = false) String branchGroup,
                                          @RequestParam(value = "collectionOfBranch", required = false) String collectionOfBranch) {
        try {
            if (ValidatorClass.validateCutOffInfo(settlementDate, branchGroup, collectionOfBranch)) {
                return new ResponseEntity(ValidatorClass.result.toString(), HttpStatus.BAD_REQUEST);
            } else {
                List<CutOfAmount> objList=cutoffamountService.fetchCutOfInfo(settlementDate, branchGroup, collectionOfBranch);
                if(objList!=null&&objList.size()>0)
                return new ResponseEntity(objList, HttpStatus.OK);
                else{
                    return new ResponseEntity(CommonMethod.NotFoundMessage(), HttpStatus.NOT_FOUND);
                }
            }


        } catch (Exception ex) {
            logger.error(TAG, "Error:-" + ex.getMessage());
            return new ResponseEntity(CommonMethod.GeneralErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/afterCutOffAmount", method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity fetchAfterCutOff(@RequestParam(value = "settlementDate") String settlementDate,
                                           @RequestParam(value = "terminalCode") String terminalCode
    ) {
        try {
            if (ValidatorClass.validateAfterCutOffAmount(settlementDate, terminalCode)) {
                return new ResponseEntity(ValidatorClass.result.toString(), HttpStatus.BAD_REQUEST);
            } else {
                List<CutOfAmountAfter> objList=cutoffamountServiceAfter.fetchAfterCutOf(settlementDate, terminalCode);
                if(objList!=null&&objList.size()>0)
                return new ResponseEntity(objList, HttpStatus.OK);
                else
                    return new ResponseEntity(CommonMethod.NotFoundMessage(), HttpStatus.NOT_FOUND);

            }


        } catch (Exception ex) {
            logger.error(TAG, "Error:-" + ex.getMessage());
            return new ResponseEntity(CommonMethod.GeneralErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

