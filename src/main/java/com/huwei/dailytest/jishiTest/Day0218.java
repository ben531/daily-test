package com.huwei.dailytest.jishiTest;

import java.util.Scanner;

public class Day0218 {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

//        test1();
        test2();
    }

    /**
     * 小明从糖果盒中随意抓一把糖果
     * 每次小明会取出一半的糖果分给同学们
     * 当糖果不能平均分配时
     * 小明可以从糖果盒中(假设盒中糖果足够)取出一个或放回一个糖果
     * 小明至少需要多少次(取出放回和平均分配均记一次)能将手中糖果分至只剩一颗
     * <p>
     * 输入描述：
     * 抓取糖果数(小于1000000)：15
     * 输出描述：
     * 最少分至一颗糖果的次数：5
     * <p>
     * 示例1：
     * 输入
     * 15
     * 输出
     * 5
     * 备注
     * 解释：(1) 15+1=16;
     * (2) 16/2=8;
     * (3) 8/2=4;
     * (4) 4/2=2;
     * (5) 2/2=1;
     */
    private static void test2() {
        int m = scanner.nextInt();
        int n = 0;
        System.out.println(fentang(m, n));
    }

    private static int fentang(int m, int n) {
        if (m == 1) {
            return n;
        }
//        if (m % 2 == 0) {
//            return fentang(m / 2, n + 1);
//        }
//        return Math.min(fentang((m + 1) / 2, n + 2), fentang((m - 1) / 2, n + 2));
        if (m % 2 == 1) {
            return Math.min(fentang((m + 1) / 2, n + 2), fentang((m - 1) / 2, n + 2));
        } else {
            return fentang(m / 2, n + 1);
        }
    }

    /**
     * 输入一个字符串仅包含大小写字母和数字
     * 求字符串中包含的最长的非严格递增连续数字序列长度
     * 比如：
     * 12234属于非严格递增数字序列
     * 示例：
     * 输入
     * abc2234019A334bc
     * 输出
     * 4
     * 说明：
     * 2234为最长的非严格递增连续数字序列，所以长度为4
     * <p>
     * aaaaaa44ko543j123j7345677781
     * aaaaa34567778a44ko543j123j71
     * 345678a44ko543j123j7134567778aa
     */
    private static void test1() {
        String s = scanner.nextLine();
        String s1 = s.replaceAll("[0-9a-zA-Z]", "");
        if (s1.length() > 0) {
            return;
        }
        String s2 = s.replaceAll("[A-Za-z]", "");
        char[] chars = s2.toCharArray();
        char pre = chars[0];
        int count = 1;
        int max = -1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] >= pre) {
                count++;
            } else { // 345678445431237134567778
                max = Math.max(count, max);
                count = 1;
            }
            if (i == chars.length - 1) {
                max = Math.max(count, max);
            }
            pre = chars[i];
        }
        System.out.println(max);
    }
}
