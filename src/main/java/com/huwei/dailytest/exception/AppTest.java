package com.huwei.dailytest.exception;

import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;

import javax.jws.soap.SOAPBinding;

public class AppTest {
    public static void main(String[] args) {
        String str="";
        try {
            str = panduan();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(str);
    }

    private static String panduan() {
        String str = "";
        if (StringUtils.isEmpty(str)){
            throw new AppException(1,"failed");
        }
        return str;
    }
}
