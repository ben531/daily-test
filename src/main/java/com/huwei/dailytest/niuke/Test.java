package com.huwei.dailytest.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(String.format("%.6f", 1d / 16));
    }

    // %.2f表示保留后两位，能四舍五入。
    //1 double d = 114.145;
    //2 String.format("%.2f", d);
    private void test() {
        double d = 114.145;
        String.format("%.2f", d);
    }

    /**
     * list 排序  小->大
     */
    public static void aaa() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(5);
                add(3);
                add(6);
                add(0);
            }
        };

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        list.stream().forEach(a -> System.out.println(a));
    }
}