package com.huwei.dailytest.niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class Day0203 {
    public static void main(String[] args) {
        //输入：
        //YUANzhi1987
        //输出：
        //zvbo9441987
        // 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
        // X ，先变成小写，再往后移一位，不就是 y 了嘛，简单吧。记住，Z 往后移是 a 哦。

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'A' && chars[i] < 'Z') {
                    sb.append((char) (chars[i] + 'b' - 'A'));
                } else if (chars[i] == 'Z') {
                    sb.append('a');
                } else if (chars[i] >= 'a' && chars[i] < 'd') {
                    sb.append('2');
                } else if (chars[i] > 'c' && chars[i] < 'g') {
                    sb.append('3');
                } else if (chars[i] > 'f' && chars[i] < 'j') {
                    sb.append('4');
                } else if (chars[i] > 'i' && chars[i] < 'm') {
                    sb.append('5');
                } else if (chars[i] > 'l' && chars[i] < 'p') {
                    sb.append('6');
                } else if (chars[i] > 'o' && chars[i] < 't') {
                    sb.append('7');
                } else if (chars[i] > 's' && chars[i] < 'w') {
                    sb.append('8');
                } else if (chars[i] > 'v' && chars[i] <= 'z') {
                    sb.append('9');
                } else {
                    sb.append(chars[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }


    /**
     * 最小公倍数
     */
    private void test6() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int x = m * n;
            for (int i = 1; i <= x; i++) {
                if (i % m == 0 && i % n == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    //求最大公约数
    public static int y(int a, int b) {
        //a设定为较大的值
        if (a < b) {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        }
        //求最大公约数
        //非递归方法
//         int k;
//         //k为余数
//         while (b != 0) {
//             k = a % b;
//             a = b;
//             b = k;
//         }
//                 return a;
        //递归方法
        if (b == 0) {
            return a;
        }
        return y(b, a % b);
    }

    /**
     * 字符逆序
     */
    private void test5() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            String[] arr = new String[split.length];
            for (int i = 0; i < arr.length; i++) {
                String str = split[split.length - 1 - i];
                String daoxu = new StringBuffer(str).reverse().toString();
                arr[i] = daoxu;
                System.out.print(arr[i] + " ");
            }
        }
    }

    /**
     * 等差数列
     */
    private void test4() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a1 = 2;
            int an = a1 + (n - 1) * 3;
            System.out.println((a1 + an) * n / 2);
        }
    }

    /**
     * 求负数和均值
     */
    private void test3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0; // 负数的个数
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt();
                if (m < 0) {
                    count++;
                }
                if (m > 0) {
                    list.add(m);
                }
            }
            double asDouble = list.stream().mapToDouble(Integer::intValue).average().getAsDouble();
            System.out.println(count + " " + String.format("%.1f", asDouble));
        }
    }

    /**
     * 求组合数
     */
    private void test2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            // 求阶乘
            System.out.println(jiecheng(n + m) / jiecheng(n) / jiecheng(m));
        }
    }

    private static int jiecheng(int i) {
        if (i == 1) {
            return 1;
        }
        return i * jiecheng(i - 1);
    }

    /**
     * 密码复杂的
     */
    private void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            int score = 0;
            int upcase = 0;
            int lowerCase = 0;
            int digt = 0;
            int signs = 0;
            for (int i = 0; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    upcase++;
                } else if (Character.isLowerCase(chars[i])) {
                    lowerCase++;
                } else if (Character.isDigit(chars[i])) {
                    digt++;
                } else {
                    signs++;
                }
            }
            // 长度
            if (s.length() < 5) {
                score += 5;
            } else if (s.length() >= 5 && s.length() <= 7) {
                score += 10;
            } else {
                score += 25;
            }
            // 字母
            if ((upcase > 0 && lowerCase == 0) || (upcase == 0 && lowerCase > 0)) {
                score += 10;
            } else if (upcase > 0 && lowerCase > 0) {
                score += 20;
            }
            // 数字
            if (digt == 1) {
                score += 10;
            } else if (digt > 1) {
                score += 20;
            }
            // 符号
            if (signs == 1) {
                score += 10;
            } else if (signs > 1) {
                score += 25;
            }
            // 奖励
            if (upcase > 0 && lowerCase > 0 && digt > 0 && signs > 0) {
                score += 5;
            } else if ((upcase > 0 || lowerCase > 0) && digt > 0 && signs > 0) {
                score += 3;
            } else if ((upcase > 0 || lowerCase > 0) && digt > 0) {
                score += 2;
            }


            if (score >= 90) {
                System.out.println("VERY_SECURE");
            } else if (score >= 80) {
                System.out.println("SECURE");
            } else if (score >= 70) {
                System.out.println("VERY_STRONG");
            } else if (score >= 60) {
                System.out.println("STRONG");
            } else if (score >= 50) {
                System.out.println("AVERAGE");
            } else if (score >= 25) {
                System.out.println("WEAK");
            } else if (score >= 0) {
                System.out.println("VERY_WEAK");
            }
        }
    }

    /**
     * 最大连续bit书
     */
    private void maxBit() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            String str = Integer.toBinaryString(i);
            char[] chars = str.toCharArray();
            int max = 0;
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
            System.out.println(max);
        }
    }
}
