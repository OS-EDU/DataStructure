package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-09-04 22:15
 */
public class RadixSort {

    // 基数排序方法
    public static void radixSort(int[] arr) {
        // 得到数组中最大的数的位数
        int max = arr[0];// 假设第一位数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 得到的最大数就是几位数
        int maxLength = (max + "").length();
    }
}
