package com.huwei.dailytest.niuke;

import java.util.*;
import java.util.stream.Collectors;

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
        list.forEach(System.out::println);
    }

    @org.junit.Test
    public void test1() {
        // hashmap 按value从大到小排序
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>() {
            {
                put(1, "zs");
                put(2, "ls");
                put(3, "ww");
            }
        };
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        ArrayList<Map.Entry<Integer, String>> list1 = new ArrayList<>(entries);
        list1.sort(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        list1.forEach(System.out::println);

//        List<String> list = hashMap.values().stream().sorted().collect(Collectors.toList());
//        list.forEach(System.out::println);
//        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>() {
//            {
//                put(1, "zs");
//                put(2, "ls");
//                put(3, "ww");
//            }
//        };
//
//
//        linkedHashMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @org.junit.Test
    public void test2() {
        // 求最大公约数
        System.out.println(getY1(18, 12));
    }

    private int getY1(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        } else {
            return getY1(b, a % b);
        }


    }


    @org.junit.Test
    public void test3() {
        // 质因数分解
        List<Integer> list1 = zysfj(18);
        List<Integer> list2 = zysfj(12);
        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        for (int i = 0; i < list2.size(); i++) {
            if (!list.contains(list2.get(i))) {
                list.add(list2.get(i));
            }
        }


    }


    private List<Integer> zysfj(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sb.append(i).append(" ");
                num = num / i;
                i--;
            }
        }
        sb.append(num).append(" ");
        System.out.println(sb.toString());
        return Arrays.stream(sb.toString().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    @org.junit.Test
    public void test4() {
        // 100内的质数
        int m = 101;
        int n = (int) Math.sqrt(m);
        int[] arr = new int[m];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }
        for (int i = 2; i <= n; i++) {
            for (int j = i * i; j <= m; j += i) {
                arr[j - 1] = 1;
            }
        }
        arr[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                System.out.println(i + 1);
            }
        }
    }

    // 杨辉三角
    @org.junit.Test
    public void test5() {
        int n = 5;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
//                System.out.print(arr[i][j] + " ");
            }
//            System.out.println();
        }

        // 打印等腰三角形格式
        for (int i = 0; i < n; i++) {
            int num = n - i - 2;
            for (int j = 0; j <= num; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void test6() {
        System.out.println(gys(3, 7));
    }

    private int gys(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        } else {
            return gys(b, a % b);
        }
    }

}