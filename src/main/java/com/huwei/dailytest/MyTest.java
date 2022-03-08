package com.huwei.dailytest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MyTest {
    @Test
    public void test1() {
        String str = "aASAa";
        System.out.println(str.replaceAll("[a-z]|[A-Z]", "1"));
    }

    @Test
    public void test2() {
        int i = 3;
        i = i - 2 <= 0 ? -1 : i - 2;
        System.out.println(i);
    }

    @Test
    public void test3() {
        String str = "1 2  3 4  5";
        String[] s = str.split("[ ]+");
        System.out.println(s);
    }

    @Test
    public void test4() {
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] ints = Arrays.copyOfRange(arr, 8, 9);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ints));

//        String[] objects = Arrays.stream(arr).map(String::valueOf).toArray(String[]::new);
//        String[] strings = Arrays.copyOfRange(objects, 8, 11);
//        System.out.println(Arrays.toString(objects));
//        System.out.println(Arrays.toString(strings));
//        System.out.println(strings[2]);
    }

    @Test
    public void test5() {
        String[] arr = Arrays.stream("I am a developer.".split(" ")).toArray(String[]::new);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 3, 3)));
    }

    @Test
    public void test6() {
        List<String> list = new ArrayList<String>() {{
            add("0");
            add("1");
            add("2");
            add("3");
        }};
        List<String> strings = list.subList(3, 4);
        List<String> string = list.subList(3, 5); // 下标越界
        strings.forEach(System.out::println);
    }

    @Test
    public void test7() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(12);
            add(7);
            add(8);
        }};
        Integer remove = list.remove(1);
        System.out.println(remove);
        list.forEach(System.out::println);
    }

    @Test
    public void test8() {
        // 100 内的质数
        int n = 100;
        int[] arr = new int[n];
        arr[0] = 1; // 1 不是质数, 所以a[0]记为 1
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            // 不是质数, 记为 1
            for (int j = i * i; j <= n; j += i) {
                arr[j - 1] = 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                System.out.println(i + 1);
            }
        }
        System.out.println(Arrays.stream(arr).sum());
    }

    @Test
    public void test9() {
        for (int i = 0; i < 4; i++) {
            System.out.println((byte) (256 >> (i * 8)));
        }
    }

    @Test
    public void test10() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        long count = list.stream().count();
        System.out.println("count:" + count);
        list.stream().reduce(Integer::min).ifPresent(System.out::println);
        list.stream().reduce(Integer::max).ifPresent(System.out::println);
        list.stream().reduce((i, j) -> i * j).ifPresent(System.out::println);
    }

    public TreeSet<String> treeSet = new TreeSet<>();

    // 求全排列
    // 先背诵, 再理解
    @Test
    public void test11() {
        String[] arr = {"1", "2", "3"};

        arrange(arr, 0);

        for (String str : treeSet) {
            System.out.println(str);
        }
    }

    private void arrange(String[] arr, int k) {
        if (k == arr.length) {
            StringBuffer sb = new StringBuffer();
            for (String str : arr) {
                sb.append(str);
            }
            treeSet.add(sb.toString());
            return;
        }

        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            arrange(arr, ++k);
            swap(arr, i, --k);
        }
    }

    private void swap(String[] arr, int i, int k) {
        String temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}
