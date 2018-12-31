package com.pooyaco.powercard.config;

import com.sun.org.apache.xml.internal.utils.URI;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by a.mahdavi on 10/10/2018.
 */
public class Constant {
    public static  String Package_URL="";
    public static  String BASE_TOKEN_URL="";

    public static void makeUrl(HttpServletRequest request)
    {
        String url=request.getRequestURL().toString();
        String[] url1=url.split("/MaskanCard");
        BASE_TOKEN_URL=url1[0];
        String[] url2=url1[0].split("://");
        Package_URL=url2[1];


    }

}
