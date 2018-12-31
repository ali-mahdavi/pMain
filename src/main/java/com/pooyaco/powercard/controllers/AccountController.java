package com.pooyaco.powercard.controllers;
import com.pooyaco.powercard.common.DESedeEncryption;
import com.pooyaco.powercard.config.Constant;
import com.pooyaco.powercard.services.HsmKeyServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by a.mahdavi on 10/10/2018.
 */
@RestController
public class AccountController {
    private static Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    HsmKeyServices hsmKeyServices;
    @RequestMapping(value = "/authentication",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            method = RequestMethod.POST,
            produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
            headers = "Accept=application/json")
    public ResponseEntity getToken(
                                   HttpServletRequest request2,
                                   @RequestParam(value = "userName") String userName,
                                   @RequestParam(value = "password") String password
                           ){
        Constant.makeUrl(request2);
        //get key by user name
        String key=hsmKeyServices.getHsmKey(userName);
        String decryptedPassword="";
        try {
            DESedeEncryption deSedeEncryption =new DESedeEncryption();
            deSedeEncryption.setMyEncryptionKey(key);
            decryptedPassword=   deSedeEncryption.decrypt(password);
        String url=Constant.BASE_TOKEN_URL+"/MaskanCard/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "password");
        map.add("client_id", "the_client");
        map.add("username", userName);
        map.add("password",decryptedPassword);
        map.add("client_secret", "secret123");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
            return new ResponseEntity(response.getBody(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error:-" + e.getMessage());
            return new ResponseEntity("userName Or password is wrong",HttpStatus.UNAUTHORIZED);
        }
    }
}
