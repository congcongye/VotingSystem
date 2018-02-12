package com.service;

import com.baidu.aip.ocr.AipOcr;
import org.springframework.stereotype.Service;

/**
 * Created by ycc on 18/2/11.
 */
@Service
public class RecoginzeUtil {
    //设置APPID/AK/SK
    private static final String APP_ID = "10823458";
    private static final String API_KEY = "8v87qyM0qIlA4MXPpbNd9Tko";
    private static final String SECRET_KEY = "jG0xY128I6UNg85kv9V8OsoszK2oPYxe";
    private static  AipOcr client=new AipOcr(APP_ID, API_KEY, SECRET_KEY);
    private RecoginzeUtil(){
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    public static AipOcr getAipOcr (){
        return client;
    }
}
