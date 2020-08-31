package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-08-31 15:29
 */
public class MergeSort {

    // 分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;// 中间索引
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, right, mid, temp);
        }
    }

    // 合并的方法
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {

    }
}
