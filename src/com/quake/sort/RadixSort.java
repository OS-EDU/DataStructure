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

        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        /*
            说明：
                1、二维数组包含10个一维数组
                2、为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定位arr.length
                3、基数排序是使用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];

        // 再定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];
    }
}
