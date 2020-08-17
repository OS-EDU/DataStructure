package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-08-17 11:02
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[i]) {// 说明假定的最小值不是最小
                    min = arr[i];// 重置min
                    minIndex = j;// 重置minIndex
                }
            }
            // 将最小值，放在arr[0]，即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
