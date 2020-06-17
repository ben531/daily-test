package com.huwei.dailytest.fanxing;

public class FanxingTest {

    public GetSet<String> test = getSet("test");

    protected <T> GetSet<T> getSet(String hashKey) {
        return GetSetBuilder.of((string) -> {
            System.out.println(string);
        });
    }

    public static void main(String[] args) {
        FanxingTest fanxingTest=new FanxingTest();
        fanxingTest.test.set("string-1");
    }

}
