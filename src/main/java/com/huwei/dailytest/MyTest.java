package com.huwei.dailytest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MyTest {

    @Test
    public void test14() {
        int[][] grid = new int[][]{
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(DFS(grid));
    }

    private int DFS(int[][] grid) {
        boolean[] visited = new boolean[grid.length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(grid, visited, i);
            }
        }
        return count;
    }

    private void dfs(int[][] grid, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < grid.length; j++) {
            if (!visited[j] && grid[i][j] == 1) {
                visited[j] = true;
            }

        }
    }

    TreeSet<String> tree13 = new TreeSet<>();

    @Test
    public void test13() {
        // 全排列
        String[] arr = {"a", "b", "c"};
        arrange13(arr, 0);
        System.out.println(tree13);
    }

    private void arrange13(String[] arr, int i) {
        if (i == arr.length) {
            StringBuffer sb = new StringBuffer();
            for (String str : arr) {
                sb.append(str);
            }
            tree13.add(sb.toString());
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, j, i);
            arrange13(arr, ++i);
            swap(arr, j, --i);
        }
    }

    int step = 0;

    @Test
    public void test12() {
        String str = "7 5 9 4 2 6 8 3 5 4 3 9";
        Integer[] arr = Arrays.stream(str.split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length / 2; i++) {
            step = 1;
            step = jump(arr, i, i);
            if (step != -1 && min > step) min = step;
        }
        System.out.println(min);
    }

    private int jump(Integer[] arr, int curPos, int lastPos) {
        int num = arr[curPos];
        if (lastPos == arr.length - 1) {
            return step;
        } else if (lastPos < arr.length - 1) {
            step++;
            return jump(arr, lastPos, num + lastPos);
        } else {
            return -1;
        }
    }

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
