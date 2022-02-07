package com.huwei.dailytest.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 6, 1, 8, 7, 4, 9};
        System.out.println("排序前: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int l = left;
        int r = middle + 1;
        int[] temp = new int[right - left + 1];
        int t = 0;
        while (l <= middle && r <= right) {
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t++] = arr[r++];
            }
        }
        while (l <= middle) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }


}
