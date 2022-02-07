package com.huwei.dailytest.niuke;

import java.math.BigDecimal;
import java.util.*;

public class Day0205 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
    }

    /**
     * DNA序列
     * AACTGTGCACGACCTGA
     * AACTGT
     * 5
     */
    private static void test7() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String sn = scanner.nextLine();
            int n = Integer.parseInt(sn);
            String out = "";
            double max = 0;
            for (int i = 0; i < line.length() - n + 1; i++) {
                String substring = line.substring(i, i + n);
                String replaceAll = substring.replaceAll("[^GC]", "");
                double d = replaceAll.length() * 1.0 / n;
                if (d == 1.0) {
                    out = substring;
                    break;
                }
                if (d > max) {
                    max = d;
                    out = substring;
                }
            }
            System.out.println(out);
        }
    }

    /**
     * DNA序列
     * AACTGTGCACGACCTGA
     * 5
     */
    private static void test6() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] ch = line.toCharArray();
            String str = scanner.nextLine();
            int n = Integer.parseInt(str);
            int length = line.length();
            StringBuilder sb = new StringBuilder();
            HashMap<Integer, Double> hashMap1 = new HashMap<>();
            HashMap<Integer, String> hashMap2 = new HashMap<>();
            for (int i = 0; i < length; i++) {
                if (length - i < n) {
                    break;
                }
//                sb.append(ch[i])+sb.append()
                int sum = 0;
                for (int j = i; j < n + i; j++) {
                    sb.append(ch[j]);
                    if (ch[j] == 'G' || ch[j] == 'C') {
                        sum++;
                    }
                }
                hashMap1.put(i, sum * 1.0 / n);
                hashMap2.put(i, sb.toString());
                sb.setLength(0);
            }

            Set<Map.Entry<Integer, Double>> entries = hashMap1.entrySet();
            List<Map.Entry<Integer, Double>> list = new ArrayList<>(entries);
            list.sort(new Comparator<Map.Entry<Integer, Double>>() {
                @Override
                public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                    return new BigDecimal(o2.getValue()).compareTo(new BigDecimal(o1.getValue()));
                }
            });

            Integer key = list.get(0).getKey();
            System.out.println(hashMap2.get(key));
        }
    }

    /**
     * 找出字符串中第一个只出现一次的字符
     */
    private static void test5() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] ch = str.toCharArray();
            ArrayList<Character> list = new ArrayList<>();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < ch.length; i++) {
                if (list.contains(ch[i])) {
                    set.add(ch[i]);
                    list.remove(list.indexOf(ch[i]));
                } else {
                    if (!set.contains(ch[i])) {
                        list.add(ch[i]);
                    }
                }
            }
            if (list.size() == 0) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(0));
            }
        }
    }

    /**
     * 高精度整数加法
     */
    private static void test4() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            BigDecimal bigDecimal1 = new BigDecimal(str1);
            BigDecimal bigDecimal2 = new BigDecimal(str2);
            System.out.println(bigDecimal1.add(bigDecimal2));
        }
    }

    /**
     * 挑7
     */
    private static void test3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = n; i > 0; i--) {
                if (i % 7 == 0) {
                    sum++;
                    continue;
                }
                String s = String.valueOf(i);
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == '7') {
                        sum++;
                        break;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    /**
     * 计算字符串的距离
     */
    private static void test2() {
        // 动态规划 不会做
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            int dp[][] = new int[s1.length() + 1][s2.length() + 1];
            dp[0][0] = 0;
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i < dp[0].length; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                    }
                }
            }
            System.out.println(dp[s1.length()][s2.length()]);
        }
    }


    /**
     * 从单向链表中删除指定值的节点
     * 输入：
     * 5 2 3 2 4 3 5 2 1 4 3
     * 输出：
     * 2 5 4 1
     */
    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int first = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(first);
            for (int i = 0; i < n - 1; i++) {
                int value = scanner.nextInt();
                int index = scanner.nextInt();
                list.add(list.indexOf(index) + 1, value);
            }

            int remove = scanner.nextInt();
            list.remove(list.indexOf(remove));
            list.forEach(e -> System.out.print(e + " "));
        }
    }
}
