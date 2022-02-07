package com.huwei.dailytest.niuke;

import java.util.*;

public class Day0206 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

    /**
     * 字符统计
     */
    private static void test6() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (!treeMap.containsKey(str.charAt(i))) {
                    treeMap.put(str.charAt(i), 1);
                } else {
                    Integer n = treeMap.get(str.charAt(i));
                    treeMap.put(str.charAt(i), n + 1);
                }
            }

            Set<Map.Entry<Character, Integer>> entries = treeMap.entrySet();
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
            list.sort(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            list.forEach(e -> System.out.print(e.getKey()));
            System.out.println();
        }
    }

    private static void test5() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        double num = Double.parseDouble(s);
        double x = Dichotomy(num);
        System.out.printf("%.1f", x);
    }

    /**
     * 使用类似二分的思路 求立方根
     *
     * @param num
     * @return
     */
    private static double Dichotomy(double num) {
        double right, left, mid = 0.0;
        //一定要注意边界条件，输入的num可能是负数  将x<-1的边界范围定为[x,1]，x>1的边界范围定为[-1,x]
        right = Math.max(1.0, num);
        left = Math.min(-1.0, num);
        while (right - left > 0.001) {
            mid = (left + right) / 2;
            //如果乘积大于num，说明立方根在mid的左侧
            if (mid * mid * mid > num) {
                right = mid;
            } else if (mid * mid * mid < num) {
                //如果乘积小于num，说明立方根在mid的右侧
                left = mid;
            } else {
                return mid;
            }
        }
        return right;
    }

    /**
     * 矩阵乘法
     */
    private static void test4() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 输入三个特征值
            int lamda1 = sc.nextInt();// 第一个矩阵的行
            int lamda2 = sc.nextInt();// 第一个矩阵的列 & 第二个矩阵的行
            int lamda3 = sc.nextInt();// 第二个矩阵的列
            // 声明两个数组
            int[][] matrix1 = new int[lamda1][lamda2];
            int[][] matrix2 = new int[lamda2][lamda3];
            int[][] res = new int[lamda1][lamda3];// 保存运算结果的矩阵
            for (int i = 0; i < lamda1; i++) {
                for (int j = 0; j < lamda2; j++)
                    matrix1[i][j] = sc.nextInt();
            }
            for (int i = 0; i < lamda2; i++) {
                for (int j = 0; j < lamda3; j++)
                    matrix2[i][j] = sc.nextInt();
            }
            // res[i][j] =
            int sum = 0;
            for (int i = 0; i < lamda1; i++) { // 2

                for (int j = 0; j < lamda3; j++) { // 第二个矩阵有多少列,2
                    for (int k = 0; k < lamda2; k++) { // 3
                        sum += matrix1[i][k] * matrix2[k][j]; //
//                        System.out.print(matrix1[j][k] + " "+ matrix2[k][j]);
                    }
                    res[i][j] = sum;
                    sum = 0;
                }
            }
            for (int i = 0; i < lamda1; i++) {
                for (int j = 0; j < lamda3; j++)
                    System.out.print(res[i][j] + " ");
                System.out.println();
            }

        }
    }

    private static void test3() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String strA = in.nextLine();
            String strB = in.nextLine();
            if (strA.length() > strB.length()) {
                String tmp = strA;
                strA = strB;
                strB = tmp;
            }
            int lenA = strA.length();
            String tmp;
            F:
            for (int i = 0; i < lenA; ++i) {
                for (int j = 0; j <= i; ++j) {
                    tmp = strA.substring(j, j + lenA - i);
                    if (strB.contains(tmp)) {
                        System.out.println(tmp);
                        break F;
                    }
                }
            }
        }
    }

    /**
     * 查找两个字符串的最长公共子串
     */
    private static void test2() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            int m = a.length();
            int n = b.length();
            int[][] dp = new int[m + 1][n + 1];
            int end1 = 0;
            int end2 = 0;

            int len = 0;
            boolean first = a.length() < b.length() ? true : false;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if (dp[i][j] > len) {
                            len = dp[i][j];
                            end1 = i;
                            end2 = j;
                        } else if (dp[i][j] == len) {
                            if (first) {
                                if (i < end1) {
                                    end1 = i;
                                }
                            } else {
                                if (j < end2) {
                                    end2 = j;
                                }
                            }
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            if (first) {
                System.out.println(a.substring(end1 - len, end1));
            } else {
                System.out.println(b.substring(end2 - len, end2));
            }

        }
    }

    /**
     * MP3光标位置
     */
    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String str = scanner.nextLine();

            // 页面数据大小, 默认4
            int pageSize = 4;
            if (n < pageSize) {
                pageSize = n;
            }
            // 根据指令移动current光标, 即歌曲编号
            int current = 1;
            // 光标在当前页面排第几
            int pageIndex = 1;
            for (int i = 0; i < str.length(); i++) {
                // 上移
                if (str.charAt(i) == 'U') {
                    if (current == 1) {
                        current = n;
                        pageIndex = pageSize;
                    } else {
                        current--;
                        if (pageIndex != 1) {
                            pageIndex--;
                        }
                    }
                } else {
                    if (current == n) {
                        current = 1;
                        pageIndex = 1;
                    } else {
                        current++;
                        if (pageIndex != pageSize) {
                            pageIndex++;
                        }
                    }
                }
            }

            // 计算光标前后数字个数
            int next = pageSize - pageIndex;
            int pre = pageSize - 1 - next;
            // 打印页面
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= pre; i++) {
                list.add(current - i); // 此时得到的list是倒序的
            }

            list.add(current);
            for (int i = 1; i <= next; i++) {
                list.add(current + i);
            }
//            List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            list.forEach(e -> System.out.print(e + " "));
            System.out.println();
            System.out.println(current);
        }
    }
}
