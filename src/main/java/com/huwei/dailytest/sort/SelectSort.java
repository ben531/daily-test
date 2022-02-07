package com.huwei.dailytest.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length - 1; j++) {
            int minVal = arr[j];
            int minValIndex = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (minVal > arr[i]) {
                    minVal = arr[i];
                    minValIndex = i;
                }
            }
            arr[minValIndex] = arr[j];
            arr[j] = minVal;
        }

        System.out.println(Arrays.toString(arr));
    }
}
