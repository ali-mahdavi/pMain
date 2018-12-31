package com.pooyaco.powercard.utility;


import com.google.gson.JsonObject;
import com.pooyaco.utils.DateUtils;
import com.pooyaco.utils.JalaliDate;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by a.mahdavi on 01/12/18.
 */
public class CommonMethod {
     public  static final int STATUS_CODE_NOT_EMPTY=213;
     public  static final int STATUS_CODE_NOT_VALIDAITE=214;
     public  static final int STATUS_CODE_NOT_VALIDAITE_FORMATE=203;
     public  static final int STATUS_CODE_NOT_FOUND_INPERIOD=204;
     public  static final int STATUS_CODE_NOT_FOUND=404;
     public  static final int STATUS_SUCCESS=200;
     public  static final int STATUS_INTERNAL_SERVER_ERROR=500;




    public static  String DateToShamsi(String date){
        if(date==null)return "";
        try {
            String[] string1 = date.split(" ");
            if(string1==null||string1.length<=1)return "";
            Date  date1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(string1[0]);
            JalaliDate jalaliCalendar= DateUtils.convertGregorianToJalali(date1);
            String sdf=jalaliCalendar.toString();
            return  jalaliCalendar.getYear()+"-"+jalaliCalendar.getMonth()+"-"+jalaliCalendar.getDay()+" "+ string1[1].substring(0,string1[1].length()-2);
        }
        catch(Exception exp){
            exp.printStackTrace();
            return "";
        }
    }
    public static  String ResultUpdateMessage(boolean flage){
        JsonObject msg=new JsonObject();
        if(flage)
        {
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_SUCCESS);
            obj.addProperty("message","اطلاعات با موفقیت بروز رسانی گردید");
            msg.add("result",obj);
        }
        else{
            JsonObject obj=new JsonObject();
            obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_FOUND_INPERIOD);
            obj.addProperty("message","اطلاعاتی در این بازه زمانی یافت نشد");
            msg.add("result",obj);
        }
        return  msg.toString();
    }

    public static  String NotFoundMessage(){
        JsonObject msg=new JsonObject();
        JsonObject obj=new JsonObject();
        obj.addProperty("statusCode",CommonMethod.STATUS_CODE_NOT_FOUND);
        obj.addProperty("message","ركوردی یافت نشد");
        msg.add("result",obj);
        return  msg.toString();
    }

    public static  String GeneralErrorMessage(){
        JsonObject msg=new JsonObject();
        JsonObject obj=new JsonObject();
        obj.addProperty("statusCode", CommonMethod.STATUS_INTERNAL_SERVER_ERROR);
        obj.addProperty("message","در اجرای وب سرویس خطای سیستمی رخ داده است.");
        msg.add("result",obj);
        return  msg.toString();
    }

    public static  boolean isValidDate(String input) {
        try {
            if(input.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                format.parse(input);

                return true;
            }else return false;
        }
        catch(ParseException e){
            return false;
        }
    }
}
