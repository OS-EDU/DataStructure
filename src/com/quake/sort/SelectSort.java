package com.quake.sort;

import java.util.Arrays;

/**
 * @author AKA二夕
 * @create 2020-08-17 11:02
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("原始的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序之后的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {// 说明假定的最小值不是最小
                    min = arr[j];// 重置min
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
