package com.huwei.dailytest.niuke;

import java.util.Random;
import java.util.Scanner;

public class Day0117 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int val = sc.nextInt();
            int[] num = new int[val];
            Random random = new Random();
            for (int i = 0; i < val; i++) {
                num[i] = random.nextInt(1000) + 1;
            }
            int[] result = new int[1001];
            for (int i = 0; i < num.length; i++) {
                result[num[i]] = num[i];
            }
            for (int i = 0; i < result.length; i++) {
                if (result[i] != 0)
                    System.out.println(result[i]);
            }

        }
    }

    private static void t1(Scanner sc) {
        String str = sc.nextLine();
        String[] s = str.split(" ");
        System.out.println(s[s.length - 1].length());
    }

    private static void t2(Scanner sc) {
        String str = sc.nextLine();
        String s = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (s.equalsIgnoreCase(String.valueOf(str.charAt(i)))) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
