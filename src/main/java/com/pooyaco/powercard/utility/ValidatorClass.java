package com.pooyaco.powercard.utility;

import com.google.gson.JsonObject;

/**
 * Created by a.mahdavi on 11/19/2018.
 */
public class ValidatorClass {
    public static JsonObject result;

    public static boolean validateCutOffInfo(String settlementDate,
                                             String branchGroup,
                                             String collectionOfBranch){
        boolean flage =false;
        JsonObject errors=new JsonObject();
        result =new JsonObject();
        if(settlementDate!=null&&(settlementDate.length()>30)) {
            String msg=" باید برابر یا کوچکتر از  30 کاراکتر باشد "+"settlementDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("settlementDate", obj);
            flage=true;
        }

        if(settlementDate!=null&& !CommonMethod.isValidDate(settlementDate)) {
            String msg=" پر شود "+"YYYY-MM-DD"+" بايد با فرمت "+"settlementDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE_FORMATE);
            obj.addProperty("message",msg);
            errors.add("settlementDate", obj);
            flage=true;
        }


        if(settlementDate!=null&&settlementDate.isEmpty()) {
            String msg=" نباید خالی باشد "+"settlementDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("settlementDate", obj);
            flage=true;

        }

        if(branchGroup!=null&&branchGroup.isEmpty()) {
            String msg=" نباید خالی باشد "+"branchGroup"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("branchGroup", obj);
            flage=true;

        }

        if(branchGroup!=null&&branchGroup.length()>3) {
            String msg=" باید برابر با یا کوچکتر از 3 کاراکتر باشد "+"branchGroup"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("branchGroup", obj);
            flage=true;

        }
        if(collectionOfBranch!=null&&collectionOfBranch.isEmpty()) {
            String msg="نباید خالی باشد "+"collectionOfBranch"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("collectionOfBranch", obj);
            flage=true;
        }
        if(collectionOfBranch!=null&&(collectionOfBranch.length()>6)) {
            if(!collectionOfBranch.contains(",")&&collectionOfBranch.length()!=6){
                String msg=" بایستی با کاراکتر ','  از هم جدا شوند "+"collectionOfBranch"+" فيلد های ";
                JsonObject obj=new JsonObject();
                obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
                obj.addProperty("message",msg);
                errors.add("collectionOfBranch", obj);

                flage=true;
            }else{
                String[] collection=collectionOfBranch.split(",");
                for (String branch:collection
                     ) {

                    if(branch!=null&&branch.length()>6)
                    {
                        String msg=" باید برابر با یا کوچکتر از 6 کاراکتر باشد "+"collectionOfBranch"+" فيلد ";
                        JsonObject obj=new JsonObject();
                        obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
                        obj.addProperty("message",msg);
                        errors.add("collectionOfBranch", obj);
                        flage=true;
                    }
                }
            }


        }else
            if(collectionOfBranch!=null&&collectionOfBranch.length()<6)
            {
                String msg=" باید برابر با  یا کوچکتر از 6 کاراکتر باشد "+"collectionOfBranch"+" فيلد ";
                JsonObject obj=new JsonObject();
                obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
                obj.addProperty("message",msg);
                errors.add("collectionOfBranch", obj);
                flage=true;
        }
        result.add("result",errors);
        return flage;
    }

    public static boolean validateAfterCutOffAmount(String settlementDate,String terminalCode){
        boolean flage=false;
        result =new JsonObject();
        JsonObject errors=new JsonObject();
        if(settlementDate!=null&&(settlementDate.length()>30)) {
            String msg=" باید برابر یا کوچکتر از 30 کاراکتر باشد "+"settlementDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("settlementDate", obj);

            flage=true;

        }

        if(settlementDate!=null&& !CommonMethod.isValidDate(settlementDate)) {
            String msg=" پر شود "+"YYYY-MM-DD"+" بايد با فرمت "+"settlementDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE_FORMATE);
            obj.addProperty("message",msg);
            errors.add("settlementDate", obj);
            flage=true;
        }
        if(settlementDate!=null&&settlementDate.isEmpty()) {
            String msg=" نباید خالی باشد "+"settlementDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("settlementDate", obj);
            flage=true;

        }

        if(terminalCode!=null&&(terminalCode.length()>15)) {
            String msg=" باید برابر با یا کوچکتر از 15 کاراکتر باشد "+"terminalCode"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("terminalCode", obj);
            flage=true;

        }
        if(terminalCode!=null&&terminalCode.isEmpty()) {
            String msg=" نباید خالی باشد "+"terminalCode"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("terminalCode", obj);
            flage=true;

        }
        result.add("result",errors);
        return flage;

    }

    public static boolean validateGetArchieved(String reportName, String reportDate, String identifier) {
        boolean flage=false;
        result =new JsonObject();
        JsonObject errors=new JsonObject();
        if(reportName!=null&&(reportName.length()>40)) {
            String msg=" باید برابر با یا کوچکتر از 40 کاراکتر باشد "+"reportName"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("reportName", obj);
            flage=true;

        }
        if(reportName!=null&&reportName.isEmpty()) {
            String msg=" نباید خالی باشد "+"reportName"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("reportName", obj);

            flage=true;

        }

        if(reportDate!=null&&(reportDate.length()>30)) {
            String msg=" باید برابر با یا کوچکتر از 30 کاراکتر باشد "+"reportDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("reportDate", obj);

            flage=true;

        }

        if(reportDate!=null&& !CommonMethod.isValidDate(reportDate)) {
            String msg=" پر شود "+"YYYY-MM-DD"+" بايد با فرمت "+"reportDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE_FORMATE);
            obj.addProperty("message",msg);
            errors.add("reportDate", obj);

            flage=true;
        }

        if(reportDate!=null&&reportDate.isEmpty()) {
            String msg=" نباید خالی باشد "+"reportDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("reportDate", obj);
            flage=true;

        }

        if(identifier!=null&&(identifier.length()!=3)) {
            String msg=" باید برابر 3 کاراکتر باشد "+"identifier"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("identifier", obj);
            flage=true;

        }
        if(identifier!=null&&identifier.isEmpty()) {
            String msg=" نباید خالی باشد "+"identifier"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("identifier", obj);
            flage=true;

        }
        result.add("result",errors);
        return flage;
    }

    public static boolean validateUpdateArchieved(String reportName, String reportDate,
                                                  String identifier, String descNumber, String descDate) {
        boolean flage=false;
        result =new JsonObject();
        JsonObject errors=new JsonObject();
        if(reportName!=null&&(reportName.length()>40)) {
            String msg=" باید برابر با یا کوچکتر از 40 کاراکتر باشد "+"reportName"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("reportName", obj);
            flage=true;

        }
        if(reportName!=null&&reportName.isEmpty()) {
            String msg=" نباید خالی باشد "+"reportName"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("reportName", obj);

            flage=true;

        }

        if(reportDate!=null&&(reportDate.length()>30)) {
            String msg=" باید برابر با یا کوچکتر از 30 کاراکتر  "+"reportDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("reportDate", obj);

            flage=true;

        }

        if(reportDate!=null&& !CommonMethod.isValidDate(reportDate)) {
            String msg=" پر شود "+"YYYY-MM-DD"+" بايد با فرمت "+"reportDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE_FORMATE);
            obj.addProperty("message",msg);
            errors.add("reportDate", obj);
            flage=true;
        }
        if(reportDate!=null&&reportDate.isEmpty()) {
            String msg=" نباید خالی باشد "+"reportDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("reportDate", obj);

            flage=true;

        }

        if(identifier!=null&&(identifier.length()!=3)) {
            String msg=" باید برابر 3 کاراکتر باشد "+"identifier"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("identifier", obj);
            flage=true;

        }
        if(identifier!=null&&identifier.isEmpty()) {
            String msg=" نباید خالی باشد "+"identifier"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("identifier", obj);
            flage=true;

        }

        if(descNumber!=null&&(descNumber.length()>100)) {
            String msg=" باید برابر با یا کوچکتر از 100 کاراکتر باشد "+"descNumber"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("descNumber", obj);

            flage=true;

        }
        if(descNumber!=null&&descNumber.isEmpty()) {
            String msg=" نباید خالی باشد "+"descNumber"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("descNumber", obj);

            flage=true;

        }

        if(descDate!=null&&(descDate.length()>30)) {
            String msg=" باید برابر با یا کوچکتر از 30 کاراکتر باشد "+"descDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE);
            obj.addProperty("message",msg);
            errors.add("descDate", obj);
            flage=true;

        }

        if(descDate!=null&& !CommonMethod.isValidDate(descDate)) {
            String msg=" پر شود "+"YYYY-MM-DD"+" بايد با فرمت "+"descDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_VALIDAITE_FORMATE);
            obj.addProperty("message",msg);
            errors.add("descDate", obj);
            flage=true;
        }
        if(descDate!=null&&descDate.isEmpty()) {
            String msg=" نباید خالی باشد "+"descDate"+" فيلد ";
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_EMPTY);
            obj.addProperty("message",msg);
            errors.add("descDate", obj);
            flage=true;

        }
        result.add("result",errors);
        return flage;
    }
}
