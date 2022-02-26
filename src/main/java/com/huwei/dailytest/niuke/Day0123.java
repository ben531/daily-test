package com.huwei.dailytest.niuke;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day0123 {
    public static void main(String[] args) {
        test10();

    }

    private void test12() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Integer value = Integer.valueOf(line);
            String[] arr = new String[value];
            for (int i = 0; i < value; i++) {
                arr[i] = scanner.nextLine();
            }
            Arrays.sort(arr);
            for (int i = 0; i < value; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    private void test11() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < nextLine.length(); i++) {
            hashSet.add(nextLine.charAt(i));
        }
        System.out.println(hashSet.size());
    }

    private static void test10() {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        getPrimer(num);
    }

    /**
     * 取根号num作为比较总次数来避免大质数超时，递归思想
     *
     * @param num
     */
    private static void getPrimer(long num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                System.out.println(i + " ");
                getPrimer(num / i);
                break;
            }
            if (i == sqrt) {
                System.out.println(num + " ");
            }
        }
    }


    /**
     * 求一个数值的所有质数  * 解题思路：遍历1~数值中的所有数，作除判断，一个个抽出所有质数
     */
    private static void test9() {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        List<Integer> out = getAllPrimeNum(input);
        for (Integer i : out) {
            System.out.print(i + " ");
        }
    }

    /**
     * 根据数值获取所有质数  * @param input  * @return
     */
    private static List<Integer> getAllPrimeNum(int input) {
        if (input <= 1) {
            return null;
        }
        List<Integer> primeNums = new ArrayList<>();
        while (input != 1) {
            for (int i = 2; i <= input; i++) {
                if (input % i == 0) {
                    input /= i;
                    primeNums.add(i);
                    break;
                }
            }
        }
        return primeNums;
    }

    private void test8() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int num = str.length() % 8;
            if (str != null && str != "") {
                if (num > 0) {
                    for (int i = 0; i < 8 - num; i++) {
                        str = str + "0";
                    }
                }
                for (int i = 0; i < (str.length() / 8); i++) {
                    System.out.println(str.substring(8 * i, 8 * (i + 1)));
                }
            }
        }
    }

    private void test7() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
//        String a = "$bo*y gi!r#l";
        String[] split = a.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            String str = split[i];
            if (isWord(str)) {
                sb.append(str + " ");
            } else {
                StringBuilder sb1 = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    String s = String.valueOf(str.charAt(j));
                    if (isWord(s)) {
                        sb1.append(s);
                    } else {
                        sb1.append(" ");
                    }
                }
                String toString = sb1.toString();
                String[] split1 = toString.split(" ");
                for (int j = split1.length - 1; j >= 0; j--) {
                    sb.append(split1[j] + " ");
                }
            }
        }
        String toString = sb.toString();
        String substring = toString.substring(0, toString.length() - 1);
        System.out.println(substring);
    }

    private static boolean isWord(String str) {
        Pattern pattern = Pattern.compile("[a-z|A-Z]*");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }


    private void test6() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
//        String a = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
        String[] split = a.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < split.length; i++) {
            if (isOk(split[i])) {
                String d = String.valueOf(split[i].charAt(0));
                int v = Integer.parseInt(split[i].substring(1));
                switch (d) {
                    case "A":
                        x -= v;
                        break;
                    case "S":
                        y -= v;
                        break;
                    case "D":
                        x += v;
                        break;
                    case "W":
                        y += v;
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }

    private static boolean isOk(String str) {
        if (str.length() > 3 || str.length() == 0) {
            return false;
        }
        if (!(str.startsWith("A") || str.startsWith("S") || str.startsWith("W") || str.startsWith("D"))) {
            return false;
        }
        String substring = str.substring(1);
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(substring);
        if (isNum.matches()) {
            return true;
        }
        return false;
    }


    private void test5() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String toBinaryString = Integer.toBinaryString(a);
        int sum = 0;
        for (int i = 0; i < toBinaryString.length(); i++) {
            if (Integer.parseInt(String.valueOf(toBinaryString.charAt(i))) == 1) {
                sum++;
            }
        }
        System.out.println(sum);

    }

    private void test4() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] split = a.split(" ");
        if (split.length == 1) {
            System.out.println(split[0]);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = split.length - 1; i >= 0; i--) {
                sb.append(split[i] + " ");
            }
            String toString = sb.toString();
            String result = toString.substring(0, toString.length() - 1);
            System.out.println(result);
        }
    }

    private void test3() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = a.length() - 1; i >= 0; i--) {
            sb.append(String.valueOf(a.charAt(i)));
        }
        System.out.println(sb.toString());
    }

    private void test2() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a == 0) {
            System.out.println("0");
        }
        StringBuffer sb = new StringBuffer();
        while (a > 0) {
            int last = a % 10;
            a /= 10;
            sb.append(last);
        }
        System.out.println(sb.toString());
    }

    private void test1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String s1 = String.valueOf(s.charAt(i));
            if (list.contains(s1)) {
                continue;
            } else {
                list.add(s1);
            }
        }
        list.stream().forEach(a -> System.out.print(a));
    }
}
