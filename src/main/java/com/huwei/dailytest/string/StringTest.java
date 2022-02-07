package com.huwei.dailytest.string;

public class StringTest {
    public static void main(String[] args) {
        String a = "abc";
        String b = "a";
        String c = b + "bc";
        b = b + "bc";
        String d = "a" + "bc";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
    }
}
