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

    /** 合并的方法
     *
     * @param arr 待排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param right 右边有序序列的初始索引
     * @param mid 中间索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;// 初始化i，左边有序序列的初始索引
        int j = right;// 初始化j，右边有序序列的初始索引
        int t = 0;// 指向temp数组的当前索引

        
    }
}
