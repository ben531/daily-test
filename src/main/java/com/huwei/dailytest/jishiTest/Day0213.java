package com.huwei.dailytest.jishiTest;

import java.util.*;
import java.util.stream.Collectors;

public class Day0213 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        test59();
//        test59_1();
//        test58();
//        test58_1();
//        test57();
//        test56();
//        test55();
        test54();
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
    private static void test54() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int begin = Integer.parseInt(scanner.nextLine());
            int end = Integer.parseInt(scanner.nextLine());
            if (begin > end) {
                System.out.println("EMPTY");
                return;
            }
            String[] s1 = s.split("\\s+");
            if (s1.length < (end - begin + 1)) {
                System.out.println("EMPTY");
                return;
            }
            String[] sub1 = {};
            if (begin > 0) {
                sub1 = Arrays.copyOfRange(s1, 0, begin);
            }
            String[] sub2 = {};
            String[] sub3 = {};
            // 6
            // 56
            if (end <= s1.length - 2) {
                sub2 = Arrays.copyOfRange(s1, begin, end + 1);
                sub3 = Arrays.copyOfRange(s1, end + 1, s1.length);
            } else if (end == s1.length - 1) {
                sub2 = Arrays.copyOfRange(s1, begin, end + 1);
            } else if (end > s1.length - 1) {
                System.out.println("EMPTY");
                return;
            }

            StringBuffer sb = new StringBuffer();
            StringBuffer sb1 = new StringBuffer();
            for (int i = sub2.length - 1; i >= 0; i--) {
                sb.append(sub2[i]).append(" ");
            }
            for (int i = 0; i < sub1.length; i++) {
                sb1.append(sub1[i]).append(" ");
            }
            sb1.append(sb);
            for (int i = 0; i < sub3.length; i++) {
                sb1.append(sub3[i]).append(" ");
            }
            System.out.println(sb1);

        }
    }

    /**
     * 单词接龙的规则是
     * 可用于接龙的单词首字母必须要与前一个单词的尾字母相同
     * 当存在多个首字母相同的单词时
     * 取长度最长的单词
     * 如果长度也相等则取词典序最小的单词
     * 已经参与接龙的单词不能重复使用
     * 现给定一组全部由小写字母组成的单词数组
     * 并指定其中的一个单词为起始单词
     * 进行单词接龙
     * 请输出最长的单词串
     * 单词串是由单词拼接而成 中间没有空格
     * <p>
     * 输入描述：
     * 输入的第一行为一个非负整数
     * 表示起始单词在数组中的索引k  0<=k<=n
     * 第二行输入的是一个非负整数表示单词的个数n
     * 接下来的n行分别表示单词数组中的单词
     * <p>
     * 输出描述：
     * 输出一个字符串表示最终拼接的字符串
     * <p>
     * 示例1：
     * 输入
     * 0
     * 6
     * word
     * dd
     * da
     * dc
     * dword
     * d
     * <p>
     * 输出
     * worddwordda
     * <p>
     * 说明：
     * 先确定起始单词word
     * 再确定d开头长度最长的单词dword
     * 剩余以d开头且长度最长的由 da dd dc
     * 则取字典序最小的da
     * 所以最后输出worddwordda
     * <p>
     * 示例二：
     * 输入：
     * 4
     * 6
     * word
     * dd
     * da
     * dc
     * dword
     * d
     * 输出：
     * dwordda
     */
    private static void test55() {
        while (scanner.hasNext()) {
            int k = Integer.parseInt(scanner.nextLine());
            int n = Integer.parseInt(scanner.nextLine());
            if (k == n) {
                System.out.println("");
                return;
            }
            List<Test55_1> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String str = scanner.nextLine();
                list.add(new Test55_1(str.charAt(0), str.length(), str));
            }

            Test55_1 test55_1 = list.get(k);
            list.remove(k);
            StringBuffer sb = new StringBuffer();
            sb.append(test55_1.str);
            while (true) {
                List<Test55_1> tempList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    char c = sb.charAt(sb.length() - 1);
                    Test55_1 test55_11 = list.get(i);
                    if (c == test55_11.first) {
                        tempList.add(test55_11);
                    }
                }
                if (tempList.size() == 0) {
                    break;
                }
                tempList.sort(new Comparator<Test55_1>() {
                    @Override
                    public int compare(Test55_1 o1, Test55_1 o2) {
                        if (o1.length != o2.length) {
                            return o1.length < o2.length ? 1 : -1;
                        }
                        return o1.str.compareTo(o2.str);
//                        return o1.hashCode() < o2.hashCode() ? -1 : 1;
                    }
                });
                Test55_1 test55_11 = tempList.get(0);
                sb.append(test55_11.str);
                list.remove(test55_11);
                tempList.clear();
            }
            System.out.println(sb.toString());
        }
    }

    static class Test55_1 {
        char first;
        int length;
        String str;

        public Test55_1(char c, int length, String str) {
            this.first = c;
            this.length = length;
            this.str = str;
        }

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
    private static void test56() {
        while (scanner.hasNext()) {
            // 1s最多执行多少个
            int n = Integer.parseInt(scanner.nextLine());
            // 有多少任务
            int m = Integer.parseInt(scanner.nextLine());
            List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int sum = 0;
            int mod = 0;
            for (int i = 0; i < collect.size(); i++) {
                Integer integer = collect.get(i);
                int i1 = (mod + integer) / n == 0 ? 1 : (mod + integer) / n;
                sum += i1;
                mod = (mod + integer) / n == 0 ? 0 : (mod + integer) % n;
            }
            System.out.println(sum);
        }

    }

    /**
     * 给定一个字符串
     * 只包含大写字母
     * 求在包含同一字母的子串中
     * 长度第K长的子串
     * 相同字母只取最长的子串
     * <p>
     * 输入
     * 第一行 一个子串 1<len<=100
     * 只包含大写字母
     * 第二行为k的值
     * <p>
     * 输出
     * 输出连续出现次数第k多的字母的次数
     * <p>
     * 例子：
     * 输入
     * AABAAA
     * 2
     * 输出
     * 1
     * 同一字母连续出现最多的A 3次
     * 第二多2次  但A出现连续3次
     * <p>
     * 输入
     * AAAAHHHBBCDHHHH
     * 3
     * 输出
     * 2
     * //如果子串中只包含同一字母的子串数小于k
     * 则输出-1
     */
    private static void test57() {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int k = Integer.parseInt(scanner.nextLine());
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> hashMap = new HashMap<>();
            char cur = chars[0];
            int count = 1;
            hashMap.put(cur, count);
            for (int i = 1; i < chars.length; i++) {
                char c = chars[i];
                if (c == cur) {
                    count++;
                } else {
                    cur = c;
                    count = 1;
                }
                Integer orDefault = hashMap.getOrDefault(c, 0);
                if (orDefault < count) {
                    hashMap.put(c, count);
                }
            }

//            for (int i = 0; i < chars.length; i++) {
//                char c = chars[i];
//                Integer orDefault = hashMap.getOrDefault(c, 0);
//                int j = i + 1;
//                int count = 1;
//                while (j < chars.length && chars[j] == c) {
//                    count++;
//                    j++;
//                }
//                if (orDefault < count) {
//                    hashMap.put(c, count);
//                }
//                i = j - 1;
//            }
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());

            list.sort(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o1.getValue() < o2.getValue() ? 1 : -1;
                }
            });
            if (list.size() < k) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(k - 1).getValue());
            }
        }

    }

    private static void test58_1() {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);

        String[] split = in.nextLine().split(" ");
        int[] jobs = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            jobs[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(jobs);

        if (n <= m) {
            System.out.println(jobs[jobs.length - 1]);
            return;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            res.add(jobs[i]);
        }

        for (int i = m; i < jobs.length; i++) {
            Integer min = new ArrayList<>(new TreeSet<>(res)).get(0);
            int index = res.indexOf(min);
            res.set(index, res.get(index) + jobs[i]);
        }

        ArrayList<Integer> r = new ArrayList<>(new TreeSet<>(res));

        System.out.println(r.get(r.size() - 1));
    }

    /**
     * 一个工厂有m条流水线
     * 来并行完成n个独立的作业
     * 该工厂设置了一个调度系统
     * 在安排作业时，总是优先执行处理时间最短的作业
     * 现给定流水线个数m
     * 需要完成的作业数n
     * 每个作业的处理时间分别为 t1,t2...tn
     * 请你编程计算处理完所有作业的耗时为多少
     * 当n>m时 首先处理时间短的m个作业进入流水线
     * 其他的等待
     * 当某个作业完成时，
     * 依次从剩余作业中取处理时间最短的
     * 进入处理
     * <p>
     * 输入描述：
     * 第一行为两个整数(采取空格分隔)
     * 分别表示流水线个数m和作业数n
     * 第二行输入n个整数(采取空格分隔)
     * 表示每个作业的处理时长 t1,t2...tn
     * 0<m,n<100
     * 0<t1,t2...tn<100
     * <p>
     * 输出描述
     * 输出处理完所有作业的总时长
     * <p>
     * 案例
     * 输入
     * 3 5
     * 8 4 3 2 10
     * 输出
     * 13
     * 说明
     * 先安排时间为2,3,4的三个作业
     * 第一条流水线先完成作业
     * 调度剩余时间最短的作业8
     * 第二条流水线完成作业
     * 调度剩余时间最短的作业10
     * 总共耗时 就是二条流水线完成作业时间13(3+10)
     * <p>
     * 3 9
     * 1 1 1 2 3 4 6 7 8
     * 3 5
     * 1 2 3 4 5
     */
    private static void test58() {
        List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int m = collect.get(0);
        int n = collect.get(1);
        List<Integer> times = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        int sum = 0;
//            if (timeCe() % m == 0) {
        for (int i = times.size() - 1; i >= 0; i -= m) {
            sum += times.get(i);
        }
//            } else {
//                int j = times.size() % m;
//                for (int i = times.size() - m + j; i >= 0; i -= m) {
//                    sum += times.get(i);
//                }
//            }
        System.out.println(sum);
    }


    /**
     * 公司用一个字符串来标识员工的出勤信息
     * <p>
     * absent:    缺勤
     * late:      迟到
     * leaveearly:早退
     * present:   正常上班
     * <p>
     * 现需根据员工出勤信息,判断本次是否能获得出勤奖,
     * 能获得出勤奖的条件如下：
     * 1.缺勤不超过1次
     * 2.没有连续的迟到/早退
     * 3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
     * <p>
     * 输入描述：
     * 用户的考勤数据字符串记录条数  >=1
     * 输入字符串长度 <10000 ;
     * 不存在非法输入
     * 如：
     * 2
     * present
     * present absent present present leaveearly present absent
     * <p>
     * 输出描述：
     * 根据考勤数据字符串
     * 如果能得到考勤奖输出true否则输出false
     * 对于输出示例的结果应为
     * true false
     * <p>
     * 示例一：
     * 输入：
     * 2
     * present
     * present present
     * <p>
     * 输出：
     * true true
     * <p>
     * 示例二
     * 输入：
     * 2
     * present
     * present absent present present leaveearly present absent
     * 输出：
     * true false
     */
    private static void test59() {
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            List<List<String>> input = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<String> collect = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
                input.add(collect);
            }

            //     * 能获得出勤奖的条件如下：
            //     * 1.缺勤不超过1次
            //     * 2.没有连续的迟到/早退
            //     * 3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
            //     * absent:    缺勤
            //     * late:      迟到
            //     * leaveearly:早退
            //       present:   正常上班
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < input.size(); i++) {
                List<String> strs = input.get(i);
                long absent = strs.stream().filter(e -> e.equals("absent")).count();
                //  1.缺勤不超过1次
                if (absent > 1) {
                    sb.append("false").append(" ");
                    continue;
                }
                //  2.没有连续的迟到/早退
                for (int j = 0; j < strs.size() - 1; j++) {
                    if (("late".equals(strs.get(j)) || "leaveearly".equals(strs.get(j)))
                            && ("late".equals(strs.get(j + 1)) || "leaveearly".equals(strs.get(j + 1)))) {
                        sb.append("false").append(" ");
                        continue;
                    }
                }
                // 3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
                int[] arr = new int[strs.size()];
                for (int j = 0; j < strs.size(); j++) {
                    if ("present".equals(strs.get(j))) {
                        arr[j] = 0;
                    } else {
                        arr[j] = 1;
                    }
                }

                if (arr.length <= 7 && Arrays.stream(arr).sum() > 3) {
                    sb.append("false").append(" ");
                    continue;
                }
                if (arr.length > 7) {
                    for (int j = 0; j < arr.length - 7; j++) {
                        int[] newArr = Arrays.copyOfRange(arr, j, j + 7);
                        if (Arrays.stream(newArr).sum() > 3) {
                            sb.append("false").append(" ");
                        }
                    }
                    continue;
                }
                sb.append("true").append(" ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }

    private static void test59_1() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<List<String>> days = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(" ");
            List<String> list = Arrays.stream(split)
                    .collect(Collectors.toList());
            days.add(list);
        }
        in.close();
        StringBuilder sb = new StringBuilder();
        for (List<String> day : days) {
            //1.缺勤超过1次
            long absent = day.stream()
                    .filter(x -> x.equals("absent"))
                    .count();
            if (absent > 1) {
                sb.append("false").append(" ");
                continue;
            }
            //2.没有连续的迟到/早退
            boolean flag = true;
            for (int i = 0; i < day.size() - 1; i++) {
                String cur = day.get(i);
                String next = day.get(i + 1);
                if (("late".equals(cur) ||
                        "leaveearly".equals(cur)) &&
                        ("late".equals(next) ||
                                "leaveearly".equals(next))) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                sb.append(flag).append(" ");
                continue;
            }
            //3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
            int[] ints = new int[day.size()];
            for (int i = 0; i < day.size(); i++) {
                ints[i] = "present".equals(day.get(i)) ? 0 : 1;
            }
            if (ints.length <= 7 && Arrays.stream(ints).sum() >= 3) {
                sb.append("false").append(" ");
            } else {
                flag = true;
                for (int i = 0; i < ints.length - 7; i++) {
                    int[] subArr = Arrays.copyOfRange(ints, i, i + 7);
                    if (Arrays.stream(subArr).sum() >= 3) {
                        flag = false;
                        break;
                    }
                }
                sb.append(flag).append(" ");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));

    }
}
