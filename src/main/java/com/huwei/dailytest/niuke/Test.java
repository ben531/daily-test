package com.huwei.dailytest.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(10);
        list.add(20);
        list.remove(new Integer(3));
        list.forEach(e -> System.out.println(e));
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        treeSet.add(1);
//        treeSet.add(3);
//        treeSet.add(10);
//        treeSet.remove(3);
//        treeSet.forEach(e -> System.out.println(e));

//        System.out.println(String.format("%.6f", 1d / 16));
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