package com.huwei.dailytest.泛型;

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
            System.out.println("执行get方法");
//            setOrders.put(hashKey, "value");
            return (T) setOrders.get(hashKey);
        }, (value) -> {
            System.out.println("执行set方法");
            setOrders.put(hashKey, value);
//            setOrders.put(hashKey, "value");

        });
    }

    public static void main(String[] args) {
        FanxingTest fanxingTest = new FanxingTest("1");
        GetSet<String> test = fanxingTest.test;
        fanxingTest.setOrders.forEach((k, v) -> {
            System.out.println("k:" + "->" + v);
        });
        String s2 = test.get();
        System.out.println("s2: "+s2);
        test.set("string-1");
        String s1 = test.get();
        System.out.println("s1:"+s1);
        fanxingTest.setOrders.forEach((k, v) -> {
            System.out.println("k:" + "->" + v);
        });

        FanxingTest fanxingTest1 = new FanxingTest("1");
        String s = fanxingTest1.test.get();
        System.out.println("fanxingtest1: " + s);

    }

}
