package com.huwei.dailytest.jishiTest;

import java.util.*;
import java.util.stream.Collectors;

public class Day0225 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test10();
//        test9();
//        test8();
//        test7();
        test6();
    }

    /**
     * 为了充分发挥Gpu算力，
     * 需要尽可能多的将任务交给GPU执行，
     * 现在有一个任务数组，
     * 数组元素表示在这1s内新增的任务个数，
     * 且每秒都有新增任务，
     * 假设GPU最多一次执行n个任务，
     * 一次执行耗时1s，
     * 在保证Gpu不空闲的情况下，最少需要多长时间执行完成。
     * <p>
     * 输入描述
     * 第一个参数为gpu最多执行的任务个数
     * 取值范围1~10000
     * 第二个参数为任务数组的长度
     * 取值范围1~10000
     * 第三个参数为任务数组
     * 数字范围1~10000
     * <p>
     * 输出描述
     * 执行完所有任务需要多少秒
     * <p>
     * 例子
     * 输入
     * 3
     * 5
     * 1 2 3 4 5
     * 输出
     * 6
     * <p>
     * 说明，一次最多执行3个任务  最少耗时6s
     * <p>
     * 例子2
     * 输入
     * 4
     * 5
     * 5 4 1 1 1
     * 输出
     * 5
     * <p>
     * 说明，一次最多执行4个任务  最少耗时5s
     */
    private static void test6() {
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int time = 0; // 耗时
        int mod = 0; // 余数

        for (Integer task : list) {
            task += mod;
            int timei = task / m == 0 ? 1 : task / m;
            time += timei;
            mod = task / m == 0 ? 0 : task % m;
        }
        if (mod > 0) {
            time++;
        }
        System.out.println(time);

    }

    /**
     * 小明今年升学到了小学1年纪
     * 来到新班级后，发现其他小朋友身高参差不齐
     * 然后就想基于各小朋友和自己的身高差，对他们进行排序
     * 请帮他实现排序
     * 输入描述
     * 第一行为正整数 h和n
     * 0<h<200 为小明的身高
     * 0<n<50 为新班级其他小朋友个数
     * 第二行为n各正整数
     * h1 ~ hn分别是其他小朋友的身高
     * 取值范围0<hi<200
     * 且n个正整数各不相同
     * <p>
     * 输出描述
     * 输出排序结果，各正整数以空格分割
     * 和小明身高差绝对值最小的小朋友排在前面
     * 和小明身高差绝对值最大的小朋友排在后面
     * 如果两个小朋友和小明身高差一样
     * 则个子较小的小朋友排在前面
     * <p>
     * 示例一
     * 输入
     * 100 10
     * 95 96 97 98 99 101 102 103 104 105
     * 输出
     * 99 101 98 102 97 103 96 104 95 105
     * <p>
     * 说明  小明身高100
     * 班级学生10个  身高分别为
     */
    private static void test7() {
        String[] split = scanner.nextLine().split("\\s+");
        List<Integer> heightList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int heightBase = Integer.parseInt(split[0]);
        int num = Integer.parseInt(split[1]);
        List<Height> list = new ArrayList<>();
        for (int i = 0; i < heightList.size(); i++) {
            Integer currHeight = heightList.get(i);
            Height height = new Height(Math.abs(currHeight - heightBase), currHeight);
            list.add(height);
        }
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        list.forEach(e -> sb.append(e.height).append(" "));
        System.out.println(sb.toString().trim());
    }

    static class Height implements Comparable<Height> {
        int heightAbs;
        int height;

        public Height(int heightAbs, int height) {
            this.heightAbs = heightAbs;
            this.height = height;
        }

        @Override
        public int compareTo(Height o) {
            if (this.heightAbs == o.heightAbs) {
                return this.height - o.height;
            }
            return this.heightAbs - o.heightAbs;
        }
    }

    /**
     * 输入一个英文文章片段
     * 翻转指定区间的单词顺序，标点符号和普通字母一样处理
     * 例如输入字符串 "I am a developer."
     * 区间[0,3]则输出 "developer. a am I"
     * <p>
     * 输入描述：
     * 使用换行隔开三个参数
     * 第一个参数为英文文章内容即英文字符串
     * 第二个参数为反转起始单词下标，下标从0开始
     * 第三个参数为结束单词下标，
     * <p>
     * 输出描述
     * 反转后的英文文章片段，所有单词之间以一个半角空格分割进行输出
     * <p>
     * 示例一：
     * 输入
     * I am a developer.
     * 1
     * 2
     * 输出
     * I a am developer.
     * <p>
     * 示例二：
     * 输入
     * Hello world!
     * 0
     * 1
     * 输出
     * world! Hello
     * <p>
     * 说明：
     * 输入字符串可以在前面或者后面包含多余的空格，
     * 但是反转后的不能包含多余空格
     * <p>
     * 示例三：
     * 输入：
     * I am a developer.
     * 0
     * 3
     * 输出
     * developer. a am I
     * <p>
     * 说明：
     * 如果两个单词见有多余的空格
     * 将反转后单词间的空格减少到只含一个
     * <p>
     * 示例四：
     * 输入
     * Hello!
     * 0
     * 3
     * 输出
     * EMPTY
     * <p>
     * 说明：
     * 指定反转区间只有一个单词，或无有效单词则统一输出EMPTY
     */
    private static void test8() {
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        int begin = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        if (begin < 0 || begin >= list.size() ||
                end >= list.size() || (end - begin + 1) > list.size()) {
            System.out.println("EMPTY");
            return;
        }
        List<String> list1 = list.subList(begin, end + 1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < begin; i++) {
            sb.append(list.get(i)).append(" ");
        }
        for (int i = list1.size() - 1; i >= 0; i--) {
            sb.append(list1.get(i)).append(" ");
        }
        for (int i = end + 1; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    /**
     * 双11众多商品进行打折销售，小明想购买一些自己心意的商品
     * 但由于受购买资金限制，所以他决定从众多心意商品中购买3件
     * 而且想尽可能的花完资金
     * 现在请你设计一个程序帮助小明计算尽可能花费的最大资金额
     * <p>
     * 输入描述
     * 第一行为整型数组M 数组长度小于100 数组元素记录单个商品的价格
     * 单个商品价格<1000
     * 第二行输入为购买资金的额度R
     * R<100000
     * <p>
     * 输出描述
     * 输出为满足上述条件的最大花费额度
     * 如果不存在满足上述条件的商品请返回-1
     * <p>
     * 例子1
     * 输入
     * 23,26,36,27
     * 78
     * 输出
     * 76
     * <p>
     * 例子2
     * 输入
     * 23,30,40
     * 26
     * 输出
     * -1
     * <p>
     * 备注：输入格式正确
     */
    private static void test9() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
        if (list.size() < 3) {
            System.out.println(-1);
            return;
        }
        int money = Integer.parseInt(scanner.nextLine());

        // 2 3 5 6 8 18
        int sum;
        int max = 0;
        for (int i = 0; i <= list.size() - 3; i++) {
            sum = 0;
            sum += list.get(i) + list.get(i + 1) + list.get(i + 2);
            if (sum > money) {
                break;
            }
            if (max < sum) {
                max = sum;
            }
        }
        if (max > 0) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }

    }

    /**
     * 给定两个字符串
     * 从字符串2中找出字符串1中的所有字符
     * 去重并按照ASCII码值从小到大排列
     * 输入字符串1长度不超过1024
     * 字符串2长度不超过100
     * <p>
     * 字符范围满足ASCII编码要求，按照ASCII由小到大排序
     * <p>
     * 输入描述：
     * bach
     * bbaaccddfg
     * 输出
     * abc
     * <p>
     * 2
     * 输入
     * fach
     * bbaaccedfg
     * 输出
     * acf
     */
    private static void test10() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        TreeSet<Character> treeSet = new TreeSet<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (str2.contains(String.valueOf(c))) {
                treeSet.add(c);
            }
        }
        treeSet.stream().forEach(System.out::print);

    }
}
