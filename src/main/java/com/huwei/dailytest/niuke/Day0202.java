package com.huwei.dailytest.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Day0202 {
    public static void main(String[] args) {

    }

    private void test7() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            int max = 0;
            for (int i = 0; i < nextLine.length(); i++) {
                for (int j = nextLine.length(); j > i; j--) {
                    if (isRev(nextLine.substring(i, j))) {
                        max = Math.max(max, j - i);
                    }
                }
            }
            System.out.println(max);
        }
    }

    /**
     * 判断是否是回文
     *
     * @param str
     * @return
     */
    public static boolean isRev(String str) {
        return str.equals(new StringBuffer(str).reverse().toString());
    }

    /**
     * 统计大写字母个数
     */
    private void test6() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int count = 0;
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    /**
     * 尼克切斯定理
     * 4^3 =13 + 15 + 17 + 19
     */
    private void test5() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int last = n * (n + 1) - 1;
            int first = last - (n - 1) * 2;
            StringBuffer sb = new StringBuffer();
            for (int i = first; i <= last; i += 2) {
                sb.append(i + "+");
            }
            String str = sb.toString();
            System.out.println(str.substring(0, str.length() - 1));
        }
    }

    /**
     * 公共子字符串
     */
    private void test4() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";
        while ((str1 = bf.readLine()) != null && (str2 = bf.readLine()) != null) {
            int max = 0;
            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            for (int i = 0; i < char1.length; i++) {
                for (int j = 0; j < char2.length; j++) {
                    int t1 = i;
                    int t2 = j;
                    int count = 0;
                    while (char1[t1] == char2[t2]) {
                        t1++;
                        t2++;
                        count++;
                        max = Math.max(max, count);
                        if (t1 == char1.length || t2 == char2.length) {
                            break;
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }

    /**
     * 参数解析
     */
    private void test3() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList();
        boolean flag = false;
        for (int i = 0; i < nextLine.length(); i++) {
            char c = nextLine.charAt(i);
            if (String.valueOf(c).equals(" ") && !flag) {
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(c);
            }
            if (String.valueOf(c).equals("\"")) {
                flag = flag ? false : true;
                continue;
            }
        }
        arrayList.add(stringBuilder.toString());
        System.out.println(arrayList.size());
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    /**
     * 参数解析
     */
    private void test2() {
        // xcopy /s "C:\\program files" "d:\"
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] split = str.split(" ");
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            boolean flag = false;
            for (int i = 0; i < split.length; i++) {
                String splitI = split[i];
                if (!flag && !splitI.contains("\"")) {
                    list.add(splitI);
                } else {
                    if (splitI.startsWith("\"") && splitI.endsWith("\"")) {
                        list.add(splitI.substring(1, splitI.length() - 1));
                    } else if (splitI.startsWith("\"")) {
                        sb.append(splitI.substring(1));
                        flag = true;
                    } else if (splitI.endsWith("\"")) {
                        sb.append(" " + splitI.substring(0, splitI.length() - 1));
                        list.add(sb.toString());
                        sb = new StringBuilder();
                        flag = false;
                    } else {
                        sb.append(" " + splitI);
                    }
                }
            }
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    /**
     * 一年中的第几天
     */
    private void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();

            Calendar instance = Calendar.getInstance();
            instance.set(year, month - 1, day);
            instance.get(Calendar.DAY_OF_YEAR);
        }
    }

    /**
     * 第几天
     */
    private void dijitian() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            switch (month) {
                case 1:
                    System.out.println(day);
                    break;
                case 2:
                    System.out.println(31 + day);
                    break;
                case 3:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + day);
                    } else {
                        System.out.println(31 + 28 + day);
                    }
                    break;
                case 4:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + day);
                    }
                    break;
                case 5:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + day);
                    }
                    break;
                case 6:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + 31 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + 31 + day);
                    }
                    break;
                case 7:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + 31 + 30 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + 31 + 30 + day);
                    }
                    break;
                case 8:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + 31 + 30 + 31 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + day);
                    }
                    break;
                case 9:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + day);
                    }
                    break;
                case 10:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day);
                    }
                    break;
                case 11:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day);
                    }
                    break;
                case 12:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day);
                    } else {
                        System.out.println(31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day);
                    }
                    break;
                default:
                    break;
            }

        }
    }

    private void 百鸡() {
        // 5x+ 3y + 1/3z = 100
        // 15x + 9y + z = 300
        // x + y + z = 100
        // 7x + 4y = 100
        // 鸡翁 鸡母 鸡雏
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            for (int x = 0; x < 15; x++) {
                if ((100 - 7 * x) % 4 == 0) {
                    System.out.print(x + " " + ((100 - 7 * x) / 4) + " " + (100 - x - ((100 - 7 * x) / 4)));
                    System.out.println();
                }
            }
        }
    }
}
