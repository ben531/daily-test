package com.huwei.dailytest.jishiTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Zhongdian {
    static Scanner scanner = new Scanner(System.in);

    // 最短路径
    static int[] arr = {3, 5, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9};
    static int step = 0;

    private static void test6() {
        // 3 5 9 4 2 6 8 3 5 4 3 9
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length / 2; i++) {
            step = 1;
            int jump = jump(i, i);
            if (jump != -1) {
                result = Math.min(result, jump);
            }
        }
        System.out.println(result);

    }

    private static int jump(int curPos, int lastPos) {
        if (lastPos > arr.length - 1) {
            return -1;
        } else if (lastPos == arr.length - 1) {
            return step;
        } else {
            step++;
            return jump(lastPos, lastPos + arr[curPos]);
        }
    }

    /**
     * 绘图机器的绘图笔初始位置在原点(0,0)
     * 机器启动后按照以下规则来进行绘制直线
     * 1. 尝试沿着横线坐标正向绘制直线
     * 直到给定的终点E
     * 2. 期间可以通过指令在纵坐标轴方向进行偏移
     * offsetY为正数表示正向偏移,为负数表示负向偏移
     * <p>
     * 给定的横坐标终点值E 以及若干条绘制指令
     * 请计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积
     * 输入描述:
     * 首行为两个整数N 和 E
     * 表示有N条指令,机器运行的横坐标终点值E
     * 接下来N行 每行两个整数表示一条绘制指令x offsetY
     * 用例保证横坐标x以递增排序的方式出现
     * 且不会出现相同横坐标x
     * 取值范围:
     * 0<N<=10000
     * 0<=x<=E<=20000
     * -10000<=offsetY<=10000
     * <p>
     * 输出描述:
     * 一个整数表示计算得到的面积 用例保证结果范围在0到4294967295之内
     * 示例1:
     * 输入:
     * 4 10
     * 1 1
     * 2 1
     * 3 1
     * 4 -2
     * 输出:
     * 12
     * <p>
     * 示例2:
     * 输入:
     * 2 4
     * 0 1
     * 2 -2
     * 输出:
     * 4
     */
    private static void test64() {
        while (scanner.hasNext()) {
            List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            Integer n = collect.get(0);
            Integer e = collect.get(1);
            int mianji = 0;
            int curX = 0;
            int curY = 0;
            for (int i = 0; i < n; i++) {
                List<Integer> collect1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                Integer x = collect1.get(0);
                Integer y = collect1.get(1);

                mianji += (x - curX) * Math.abs(curY);

                curX = x;
                curY += y;
            }
            if (curX < e) {
                mianji += (e - curX) * Math.abs(curY);
            }
            System.out.println(mianji);
        }
    }

    /**
     * 现在有一队小朋友，他们高矮不同，
     * 我们以正整数数组表示这一队小朋友的身高，如数组{5,3,1,2,3}。
     * 我们现在希望小朋友排队，以“高”“矮”“高”“矮”顺序排列，
     * 每一个“高”位置的小朋友要比相邻的位置高或者相等；
     * 每一个“矮”位置的小朋友要比相邻的位置矮或者相等；
     * 要求小朋友们移动的距离和最小，第一个从“高”位开始排，输出最小移动距离即可。
     * 例如，在示范小队{5,3,1,2,3}中，{5, 1, 3, 2, 3}是排序结果。
     * {5, 2, 3, 1, 3} 虽然也满足“高”“矮”“高”“矮”顺序排列，
     * 但小朋友们的移动距离大，所以不是最优结果。
     * 移动距离的定义如下所示：
     * 第二位小朋友移到第三位小朋友后面，移动距离为1，
     * 若移动到第四位小朋友后面，移动距离为2；
     * <p>
     * 输入描述:
     * 排序前的小朋友，以英文空格的正整数：
     * 4 3 5 7 8
     * 注：小朋友<100个
     * 输出描述:
     * 排序后的小朋友，以英文空格分割的正整数：
     * 4 3 7 5 8
     * 备注：4（高）3（矮）7（高）5（矮）8（高），
     * 输出结果为最小移动距离，只有5和7交换了位置，移动距离都是1.
     * <p>
     * 示例一：
     * 输入
     * 4 1 3 5 2
     * 输出
     * 4 1 5 2 3
     * <p>
     * 示例二：
     * 输入
     * 1 1 1 1 1
     * 输出
     * 1 1 1 1 1
     * 说明：相邻位置可以相等
     * <p>
     * 示例三：
     * 输入：
     * xxx
     * 输出
     * []
     * 说明：出现非法参数情况，返回空数组
     */
    private static void test71() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            List<Integer> collect;
            try {
                collect = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            } catch (Exception e) {
                System.out.println("[]");
                return;
            } finally {
            }
            for (int i = 0; i < collect.size() - 1; i++) {
                if (i % 2 == 0 && collect.get(i) < collect.get(i + 1)) {
                    swap(collect, i, i + 1);
                }
                if (i % 2 != 0 && collect.get(i) > collect.get(i + 1)) {
                    swap(collect, i, i + 1);
                }
            }

            StringBuffer sb = new StringBuffer();
            collect.forEach(e -> sb.append(e).append(" "));
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }

    private static void swap(List<Integer> collect, Integer integer, Integer integer1) {
        Integer integer2 = collect.get(integer);
        Integer integer3 = collect.get(integer1);
        collect.set(integer, integer3);
        collect.set(integer1, integer2);
    }
}
