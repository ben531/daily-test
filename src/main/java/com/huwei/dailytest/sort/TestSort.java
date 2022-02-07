package com.huwei.dailytest.sort;

import java.util.Arrays;


public class TestSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 11, 7, 5};
        // 450
        // 36
        // 21
//        0314625


        System.out.println("排序前" + Arrays.toString(arr));

//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort1(arr);
//        shellSort2(arr);
//        quickSort(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(arr));
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
                temp[t++] = arr[l++];
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


    private static void shellSort2(int[] arr) {

        for (int m = arr.length / 2; m > 0; m /= 2) {
            for (int i = m; i < arr.length; i++) {
                int insertValIndex = i;
                int insertVal = arr[i];
                if (arr[i] < arr[i - m]) {
                    while (insertValIndex - m >= 0 && insertVal < arr[insertValIndex - m]) {
                        arr[insertValIndex] = arr[insertValIndex - m];
                        insertValIndex -= m;
                    }
                    arr[insertValIndex] = insertVal;
                }

            }
        }
    }

    private static void shellSort1(int[] arr) {
        for (int m = arr.length / 2; m > 0; m /= 2) {
            for (int i = m; i < arr.length; i++) {
                for (int j = i - m; j >= 0; j -= m) {
                    if (arr[j] > arr[j + m]) {
                        int temp = arr[j];
                        arr[j] = arr[j + m];
                        arr[j + m] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < 0 || right < 0 || left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int standNum = arr[left];
        while (i != j) {
            while (i < j && arr[j] >= standNum) {
                j--;
            }
            while (i < j && arr[i] <= standNum) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = standNum;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertValIndex = i - 1;
            while (insertValIndex >= 0 && insertVal < arr[insertValIndex]) {
                arr[insertValIndex + 1] = arr[insertValIndex];
                insertValIndex--;
            }
            arr[insertValIndex + 1] = insertVal;
            System.out.println("第" + i + "轮排序:" + Arrays.toString(arr));
        }
    }

    private static void selectSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            int minValIndex = j;
            int minVal = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if (minVal > arr[i]) {
                    minVal = arr[i];
                    minValIndex = i;
                }
            }
            arr[minValIndex] = arr[j];
            arr[j] = minVal;
            System.out.println("第" + j + "轮排序: " + Arrays.toString(arr));
        }
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            System.out.println("第" + (j + 1) + "轮: " + Arrays.toString(arr));
        }
    }


}
