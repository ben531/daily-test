package com.huwei.dailytest.jishiTest;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Day0222 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 主管期望你来实现英文输入法单词联想功能
     * 需求如下
     * 依据用户输入的单词前缀
     * 从已输入的英文语句中联想出用户想输入的单词
     * 按字典序输出联想到的单词序列
     * 如果联想不到
     * 请输出用户输入的单词前缀
     * 注意
     * 英文单词联想时区分大小写
     * 缩略形式如
     * "don't" 判定为两个单词 "don"和 "t"
     * 输出的单词序列不能有重复单词
     * 且只能是英文单词，不能有标点符号
     * <p>
     * 输入描述
     * 输入两行
     * 首行输入一段由英文单词word和标点构成的语句str
     * <p>
     * 接下来一行为一个英文单词前缀pre
     * 0 < word.length() <= 20
     * 0 < str.length <= 10000
     * 0 < pre <=20
     * <p>
     * 输出描述
     * 输出符合要求的单词序列或单词前缀
     * 存在多个时，单词之间以单个空格分割
     * <p>
     * 示例一
     * 输入
     * I love you
     * He
     * <p>
     * 输出
     * He
     * <p>
     * 说明
     * 用户已输入单词语句"I love you",
     * 中提炼出"I","love","you"三个单词
     * 接下来用户输入"He" ，
     * 从已经输入信息中无法联想到符合要求的单词
     * 所以输出用户输入的单词前缀
     * <p>
     * 示例二
     * 输入
     * The furthest distance in the world,Is not between life and death,But when I stand in front or you,Yet you don't know that I love you.
     * f
     * <p>
     * 输出
     * front furthest
     */
    private static void test4() {
        String str = scanner.nextLine();
        String pre = scanner.nextLine();
        String[] split = str.split("[\\W+]");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(pre)) {
                list.add(split[i]);
            }
        }
        list.sort(String::compareTo);
        list.forEach(e -> System.out.print(e + " "));
    }

    /**
     * 有一个N个整数的数组
     * 和一个长度为M的窗口
     * 窗口从数组内的第一个数开始滑动
     * 直到窗口不能滑动为止
     * 每次滑动产生一个窗口  和窗口内所有数的和
     * 求窗口滑动产生的所有窗口和的最大值
     * <p>
     * 输入描述
     * 第一行输入一个正整数N
     * 表示整数个数  0<N<100000
     * 第二行输入N个整数
     * 整数取值范围   [-100,100]
     * 第三行输入正整数M
     * M代表窗口的大小
     * M<=100000 并<=N
     * <p>
     * 输出描述
     * 窗口滑动产生所有窗口和的最大值
     * <p>
     * 示例一
     * 输入
     * 6
     * 12 10 20 30 15 23
     * 3
     * <p>
     * 输出
     * 68
     */
    public static void test1() {
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int m = Integer.parseInt(scanner.nextLine());

        // 3 4 2 5 6 7 1
        // 0 1 2 3 4 5 6
        // 3
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += list.get(j);
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);

    }

    /**
     * 一个整数可以由连续的自然数之和来表示
     * 给定一个整数
     * 计算该整数有几种连续自然数之和的表达式
     * 并打印出每一种表达式
     * <p>
     * 输入描述
     * 一个目标整数t  1<= t <=1000
     * <p>
     * 输出描述
     * 1.该整数的所有表达式和表达式的个数
     * 如果有多种表达式，自然数个数最少的表达式优先输出
     * 2.每个表达式中按自然数递增输出
     * <p>
     * 具体的格式参见样例
     * 在每个测试数据结束时，输出一行"Result:X"
     * 其中X是最终的表达式个数
     * <p>
     * 输入
     * 9
     * <p>
     * 输出
     * 9=9
     * 9=4+5
     * 9=2+3+4
     * Result:3
     * <p>
     * 说明 整数9有三种表达方法：
     * <p>
     * 示例二
     * 输入
     * 10
     * 输出
     * 10=10
     * 10=1+2+3+4
     * Result:2
     */
    public static void test2() {
        int m = scanner.nextInt();
        System.out.println(m + "=" + m);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < m; i++) {
            int sum = 0;
            StringBuffer sb = new StringBuffer(m + "=");
            for (int j = i; j < m; j++) {
                sb.append(j + "+");
                sum += j;
                if (sum > m) {
                    break;
                }
                if (sum == m) {
                    list.add(sb.toString().substring(0, sb.length() - 1));
                    break;
                }
            }
        }
        list.sort(Comparator.comparingInt(String::length));
        list.forEach(System.out::println);
        System.out.println("Result:" + (list.size() + 1));
    }

    /**
     * 给定一个仅包含0和1的n*n二维矩阵
     * 请计算二维矩阵的最大值
     * 计算规则如下
     * 1、每行元素按下标顺序组成一个二进制数(下标越大越排在低位)，
     * 二进制数的值就是该行的值，矩阵各行之和为矩阵的值
     * 2、允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置
     * 比如
     * [1,0,1,1,1]   向右整体循环移动两位  [1,1,1,0,1]
     * 二进制数为11101 值为29
     * [1,0,1,1,1]   向左整体循环移动两位  [1,1,1,1,0]
     * 二进制数为11110 值为30
     * <p>
     * 输入描述
     * 1.数据的第一行为正整数，记录了N的大小
     * 0<N<=20
     * 2.输入的第2到n+1行为二维矩阵信息
     * 行内元素边角逗号分割
     * <p>
     * 输出描述
     * 矩阵的最大值
     * <p>
     * 示例1
     * <p>
     * 输入
     * 5
     * 1,0,0,0,1
     * 0,0,0,1,1
     * 0,1,0,1,0
     * 1,0,0,1,1
     * 1,0,1,0,1
     * <p>
     * 1,0,0,0,1
     * 10001
     * 00011
     * 00110
     * 01100
     * 11000
     * <p>
     * 输出
     * 122
     * <p>
     * 说明第一行向右整体循环移动一位，得到最大值  11000  24
     * <p>
     * 因此最大122
     */
    @Test
    public static void test3() {
        int m = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine().replaceAll(",", "");
            list.add(s);
        }
        List<Integer> list1 = new ArrayList<>();
        for (String s : list) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < s.length(); i++) {
                String s1 = s.substring(i);
                String s2 = s.substring(0, i);
                String newStr = s1 + s2;
                int parseInt = Integer.parseInt(newStr, 2);
                max = Math.max(max, parseInt);
            }
            list1.add(max);
        }
        System.out.println(list1.stream().mapToInt(Integer::intValue).sum());

    }
}
