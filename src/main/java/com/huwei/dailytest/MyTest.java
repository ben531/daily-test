package com.huwei.dailytest;

import org.junit.Test;

public class MyTest {
    @Test
    public void test1() {
        String str = "aASAa";
        System.out.println(str.replaceAll("[a-z]|[A-Z]", "1"));
    }
}
