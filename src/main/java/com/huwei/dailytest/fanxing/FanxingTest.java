package com.huwei.dailytest.fanxing;

import java.util.HashMap;
import java.util.Map;

public class FanxingTest {

    public GetSet<String> test = getSet("test");
    public Map<String, Object> setOrders = new HashMap<>();

    protected <T> GetSet<T> getSet(String hashKey) {
        return GetSetBuilder.of((value) -> {
            System.out.println(value);
            setOrders.put(hashKey, value);
        });
    }

    public static void main(String[] args) {
        FanxingTest fanxingTest=new FanxingTest();
        fanxingTest.setOrders.forEach((k,v)->{
            System.out.println("k:"+"->"+v);
        });
        GetSet<String> test = fanxingTest.test;
        test.set("string-1");
        fanxingTest.setOrders.forEach((k,v)->{
            System.out.println("k:"+"->"+v);
        });
    }

}
