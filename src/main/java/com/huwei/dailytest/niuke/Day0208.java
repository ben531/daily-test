package com.huwei.dailytest.niuke;

import java.util.Arrays;
import java.util.Scanner;

public class Day0208 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        test1();
    }

    static class Stu implements Comparable<Stu> {
        int no;
        int h;
        int w;

        public Stu() {
        }

        public Stu(int no, int h, int w) {
            this.no = no;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Stu s) {
            if (h != s.h) {
                return h - s.h;
            }
            if (w != s.w) {
                return w - s.w;
            }
            return no - s.no;
        }

    }

    /**
     * 按身高和体重排队
     * <p>
     * 4
     * 100 100 120 130
     * 40 30 60 50
     */
    private static void test1() {
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine()); // n个人
            String h = scanner.nextLine(); //身高
            String[] height = h.split(" ");
            String w = scanner.nextLine();
            String[] weight = w.split(" ");
            Stu[] sts = new Stu[n];
            for (int i = 0; i < n; i++) {
                sts[i] = new Stu(i + 1, Integer.parseInt(height[i]), Integer.parseInt(weight[i]));
            }

            Arrays.sort(sts);
            for (Stu s : sts) {
                System.out.print(s.no + " ");
            }

        }
    }
}
