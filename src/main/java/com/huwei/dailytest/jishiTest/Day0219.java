package com.huwei.dailytest.jishiTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day0219 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    /**
     * 相对开音节构成的结构为辅音+元音(aeiou)+辅音(r除外)+e
     * 常见的单词有bike cake
     * 给定一个字符串，以空格为分隔符
     * 反转每个单词的字母
     * 若单词中包含如数字等其他非字母时不进行反转
     * 反转后计算其中含有相对开音节结构的子串个数
     * (连续子串中部分字符可以重复)
     * <p>
     * 输入描述
     * 字符串 以空格分割的多个单词
     * 长度<10000 字母只考虑小写
     * <p>
     * 输出描述
     * 含有相对开音节结构的子串个数
     * <p>
     * 示例1：
     * 输入
     * ekam a ekac
     * 输出
     * 2
     * 说明：
     * 反转后为  make a cake 其中make和cake为相对开音节子串
     * 返回2
     * <p>
     * 示例2：
     * 输入
     * !ekam a ekekac
     * 输出
     * 2
     * 说明
     * 反转后为 !ekam a cakeke
     * 因为!ekam含有非英文字母，所以未反转
     * 其中 cake和keke 为相对开音节子串 返回2
     */

    private static void test3() {
        String[] split = scanner.nextLine().split(" ");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            String s = str.replaceAll("[a-zA-Z]", "");
            if (s.length() > 0) {
                continue;
            }
            if (str.length() < 4) {
                continue;
            }
            StringBuffer sb = new StringBuffer(str);
            sb.reverse();
            sum += pand(sb.toString());
        }
        System.out.println(sum);
    }

    private static int pand(String str) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 3; i++) {
            if (!isVowel(chars[i]) &&
                    isVowel(chars[i + 1]) &&
                    (!isVowel(chars[i + 2]) && chars[i + 2] != 'r') &&
                    chars[i + 3] == 'e') {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    /**
     * 给定一个元素类型为小写字符串的数组
     * 请计算两个没有相同字符的元素长度乘积的最大值
     * 如果没有符合条件的两个元素返回0
     * <p>
     * 输入描述
     * 输入为一个半角逗号分割的小写字符串数组
     * 2<= 数组长度 <=100
     * 0< 字符串长度 <=50
     * 输出描述
     * 两个没有相同字符的元素长度乘积的最大值
     * <p>
     * 示例一
     * 输入
     * iwdvpbn,hk,iuop,iikd,kadgpf
     * 输出
     * 14
     * 说明
     * 数组中有5个元组  第一个和第二个元素没有相同字符
     * 满足条件 输出7*2=14
     */
    private static void test2() {
        String[] split = scanner.nextLine().split(",");
        int max = 0;
        for (int i = 0; i < split.length - 1; i++) {
            for (int j = 0; j < split.length - 1 - i; j++) {
                if (compare(split[j], split[j + 1])) {
                    max = Math.max(max, split[j].length() * split[j + 1].length());
                }
            }
        }
        System.out.println(max);
    }

    private static boolean compare(String s1, String s2) {
//        if (s1.length() > s2.length()) {
//            String temp = s1;
//            s1 = s2;
//            s2 = temp;
//        }
        boolean flag = true;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.indexOf(s2.charAt(i)) != -1) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    /**
     * 一辆运送快递的货车。运送的快递均放在大小不等的长方形快递盒中
     * 为了能够装载更多的快递 同时不能让货车超载
     * 需要计算最多能装多少个快递
     * 快递的体积不受限制
     * 快递数量最多1000个
     * 货车载重量50000
     * <p>
     * 输入描述：
     * 第一行输入 每个快递重量 用逗号分隔
     * 如5,10,2,11
     * 第二行 输入 货车的载重量
     * 如20
     * 不需要考虑异常输入
     * <p>
     * 输出描述：
     * 输出最多能装多少个快递
     * <p>
     * 货车的载重量为20 最多只能放3种快递 5,10,2因此输出3
     * <p>
     * 示例1：
     * 输入
     * 5,10,2,11
     * 20
     * 输出
     * 3
     */
    private static void test1() {
        List<Integer> collect = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
        int m = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int count = 0;
        for (Integer i : collect) {
            sum += i;
            if (sum > m) {
                break;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
