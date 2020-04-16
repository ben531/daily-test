package com.huwei.dailytest.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<StringBuilder> hashSet = new HashSet<>();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("a");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ab");
        hashSet.add(sb1);
        hashSet.add(sb2);
        hashSet.stream().forEach(k -> System.out.print(k + ";"));
        sb1.append("b");
        System.out.println();
        hashSet.stream().forEach(k -> System.out.print(k + ";"));

    }
}
