package com.huwei.dailytest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(list.size());
        list.set(0, 1);
    }
}
