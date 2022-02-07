package com.huwei.dailytest.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 3, 5, 7};

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "次的执行结果");
            System.out.println(Arrays.toString(arr));
        }
//        insertVal = arr[2];
//        insertIndex = 2 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第2次的执行结果");
//        System.out.println(Arrays.toString(arr));
//
//        insertVal = arr[3];
//        insertIndex = 3 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第2次的执行结果");
//        System.out.println(Arrays.toString(arr));
    }
}
