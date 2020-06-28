package com.huwei.dailytest.异常;

import org.springframework.util.StringUtils;

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
