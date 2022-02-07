package com.huwei.dailytest.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 7, 8, 5};
        System.out.println(Arrays.toString(arr));
        for (int m = arr.length / 2; m > 0; m = m / 2) {
            for (int i = m; i < arr.length; i++) {
                int insertValIndex = i;
                int insertVal = arr[i];
                while (insertValIndex - m >= 0 && insertVal < arr[insertValIndex - m]) {
                    arr[insertValIndex] = arr[insertValIndex - m];
                    insertValIndex -= m;
                }
                arr[insertValIndex] = insertVal;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
