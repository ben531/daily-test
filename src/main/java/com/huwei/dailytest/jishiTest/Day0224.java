package com.huwei.dailytest.jishiTest;

import java.util.*;
import java.util.stream.Collectors;


public class Day0224 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 喊7 是一个传统的聚会游戏
     * N个人围成一圈
     * 按顺时针从1-7编号
     * 编号为1的人从1开始喊数
     * 下一个人喊得数字是上一个人喊得数字+1
     * 但是当将要喊出数字7的倍数或者含有7的话
     * 不能喊出 而是要喊过
     * <p>
     * 假定N个人都没有失误。
     * 当喊道数字k时
     * 可以统计每个人喊 “过"的次数
     * <p>
     * 现给定一个长度n的数组
     * 存储打乱的每个人喊”过"的次数
     * 请把它还原成正确顺序
     * <p>
     * 即数组的第i个元素存储编号i的人喊“过“的次数
     * <p>
     * 输入为1行
     * 空格分割的喊过的次数
     * 注意k并不提供
     * <p>
     * k不超过200
     * 数字个数为n
     * 输出描述
     * <p>
     * 输出为1行
     * 顺序正确的喊过的次数  空格分割
     * <p>
     * 例子
     * 输入
     * 0 1 0
     * 输出
     * 1 0 0
     * <p>
     * 只有一次过
     * 发生在7
     * 按顺序编号1的人遇到7  所以100
     * 结束时的k不一定是7 也可以是 8 9
     * 喊过都是100
     * <p>
     * 例子
     * 输入
     * 0 0 0 2 1
     * 输出
     * 0 2 0 1 0
     * 一共三次喊过
     * 发生在7 14 17
     * 编号为2 的遇到7 17
     * 编号为4 的遇到14
     */
    private static void test4() {
        List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = collect.stream().mapToInt(Integer::intValue).sum();
        int count = 0;
        // 计算得出K
        int k;
        for (k = 1; ; k++) {
            if (k % 7 == 0 || (k + "").contains("7")) {
                count++;
                if (count == sum) {
                    break;
                }
            }
        }
        // 打印在K的过程中的报数
        int[] arr = new int[collect.size()];
        for (int i = 1; i <= k; i++) {
            int m = (i - 1) % arr.length;
            if (i % 7 == 0 || (i + "").contains("7")) {
                arr[m] += 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 删除字符串中出现次数最少的字符
     * 如果多个字符出现次数一样则都删除
     * <p>
     * 例子：
     * 输入
     * abcdd
     * 字符串中只
     * 输出
     * dd
     * <p>
     * 输入
     * aabbccdd
     * <p>
     * 输出
     * empty
     * <p>
     * 如果都被删除  则换为empty
     */
    private static void test3() {
        char[] chars = scanner.nextLine().toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character c : chars) {
            Integer orDefault = hashMap.getOrDefault(c, 0);
            hashMap.put(c, orDefault + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Integer min = list.get(0).getValue();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() > min) {
                break;
            } else {
                set.add(list.get(i).getKey());
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : chars) {
            if (set.contains(c)) {
                continue;
            }
            sb.append(c);
        }
        if (sb.length() == 0) {
            System.out.println("empty");
        } else {
            System.out.println(sb.toString());
        }

    }

    /**
     * 一个正整数数组 设为nums
     * 最大为100个成员
     * 求从第一个成员开始正好走到数组最后一个成员所使用的最小步骤数
     * 3 5 9 4 2 6 8 3 5 4 3 9
     * 要求：
     * 1. 第一步 必须从第一元素起  且 1<=第一步步长<len/2  (len为数组长度)
     * 2. 从第二步开始只能以所在成员的数字走相应的步数，不能多不能少，
     * 如果目标不可达返回-1
     * 只输出最小的步骤数量
     * 3. 只能向数组的尾部走不能向回走
     * <p>
     * 输入描述：
     * 有正整数数组 空格分割
     * 数组长度<100
     * <p>
     * 输出描述 ：
     * 正整数  最小步数
     * 不存在输出-1
     * <p>
     * 例子：
     * 输入
     * 7 5 9 4 2 6 8 3 5 4 3 9
     * 输出
     * 2
     * 第一个可选步长选择2
     * 从第一个成员7开始走两步到9
     * 第二步：从9经过9个成员到最后
     * <p>
     * 例子：
     * 输入
     * 1 2 3 7 1 5 9 3 2 1
     * 输出
     * -1
     */

    private static int[] ints = null;
    private static int step = 0;

    private static void test2() {
        ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 1; i < ints.length / 2; i++) {
            step = 1;
            int result = jump(i, i); // 起始位置, 跳的终点位置
            resultMap.put(i, result);
        }
        resultMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private static int jump(int curPos, int lastPos) {
        int num = ints[curPos];
        if (lastPos == ints.length - 1) {
            return step;
        } else if (lastPos < ints.length - 1) {
            step++;
            return jump(lastPos, lastPos + num);
        } else {
            return -1;
        }
    }

    /**
     * 在通信系统中有一个常见的问题是对用户进行不同策略的调度
     * 会得到不同系统消耗的性能
     * 假设由N个待串行用户，每个用户可以使用A/B/C三种不同的调度策略
     * 不同的策略会消耗不同的系统资源
     * 请你根据如下规则进行用户调度
     * 并返回总的消耗资源数
     * 规则是：相邻的用户不能使用相同的调度策略
     * 例如：
     * 第一个用户使用A策略 则第二个用户只能使用B和C策略
     * 对单的用户而言，不同的调度策略对系统资源的消耗可以规划后抽象为数值
     * 例如
     * 某用户分别使用ABC策略的系统消耗，分别为15 8 17
     * 每个用户依次选择当前所能选择的对系统资源消耗最少的策略,局部最优
     * 如果有多个满足要求的策略，选最后一个
     * <p>
     * 输入描述：
     * 第一行表示用户个数N
     * 接下来表示每一行表示一个用户分别使用三个策略的资源消耗
     * resA resB resC
     * <p>
     * 输出描述：
     * 最优策略组合下的总的系统消耗资源数
     * <p>
     * 示例一：
     * 输入：
     * 3
     * 15 8 17
     * 12 20 9
     * 11 7 5
     * <p>
     * 9 10 15
     * 1 5 7
     * 4 6 8
     * <p>
     * 输出：
     * 24
     * 说明:
     * 1号用户使用B策略
     * 2号用户使用C策略
     * 3号用户使用B策略
     * 系统资源消耗8+9+7
     */
    private static void test1() {
        int m = Integer.parseInt(scanner.nextLine());
        List<TreeMap<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            List<Integer> collect = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < collect.size(); j++) {
                treeMap.put(collect.get(j), j);
            }
            list.add(treeMap);
        }

        List<Integer> collect = list.get(0).keySet().stream().collect(Collectors.toList());
        int res1 = collect.get(0);
        int type = list.get(0).get(res1);
        if (m > 1) {
            int sum1 = res1;
            for (int i = 1; i < list.size(); i++) {
                List<Integer> collect1 = list.get(i).keySet().stream().collect(Collectors.toList());
                int resI = collect1.get(0);
                int typeI = list.get(i).get(resI);
                if (typeI != type) {
                    sum1 += resI;
                } else {
                    sum1 += collect1.get(1);
                    typeI = list.get(i).get(collect1.get(1));
                }
                type = typeI;
            }


            int res2 = collect.get(1);
            int type2 = list.get(0).get(res2);
            int sum2 = res2;
            for (int i = 1; i < list.size(); i++) {
                List<Integer> collect1 = list.get(i).keySet().stream().collect(Collectors.toList());
                int resI = collect1.get(0);
                int typeI = list.get(i).get(resI);
                if (typeI != type2) {
                    sum2 += resI;
                } else {
                    sum2 += collect1.get(1);
                    typeI = list.get(i).get(collect1.get(1));
                }
                type2 = typeI;
            }
            System.out.println(Math.min(sum1, sum2));
        } else {
            System.out.println(res1);
        }


    }
}
