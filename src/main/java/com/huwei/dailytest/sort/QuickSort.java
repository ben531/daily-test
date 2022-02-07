package com.huwei.dailytest.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 4, 1, 7, 8, 5, 0};

        System.out.println("排序前: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < 0 || right < 0 || left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int standNum = arr[left];
        while (l != r) {
            while (l < r && arr[r] >= standNum) {
                r--;
            }
            while (l < r && arr[l] <= standNum) {
                l++;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = standNum;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }
}
