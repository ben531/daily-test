package com.huwei.dailytest.fanxing;

import java.util.HashMap;
import java.util.Map;

public class FanxingTest {

    private String id;

    public FanxingTest(String id) {
        this.id = id;
    }

    public FanxingTest() {
    }

    public GetSet<String> test = getSet("test");
    public Map<String, Object> setOrders = new HashMap<>();

    protected <T> GetSet<T> getSet(String hashKey) {
        return GetSetBuilder.of(() -> {
                return (T) setOrders.get(hashKey);
        },(value) -> {
            System.out.println(value);
            setOrders.put(hashKey, value);
        });
    }

    public static void main(String[] args) {
        FanxingTest fanxingTest=new FanxingTest("1");
        GetSet<String> test = fanxingTest.test;
        fanxingTest.setOrders.forEach((k,v)->{
            System.out.println("k:"+"->"+v);
        });
        test.set("string-1");
        fanxingTest.setOrders.forEach((k,v)->{
            System.out.println("k:"+"->"+v);
        });

        FanxingTest fanxingTest1=new FanxingTest("1");
        String s = fanxingTest1.test.get();
        System.out.println("fanxingtest1: "+s);

    }

}
