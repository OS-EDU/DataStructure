package com.quake.sort;

import java.util.Arrays;

/**
 * @author AKA二夕
 * @create 2020-08-22 15:26
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 8, 6, 5, 4, 0, 9, 7};
        System.out.println("排序之前的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
        shellSort01(arr);
        System.out.println("排序之后的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
    }

    // 希尔排序，对有序序列在插入时直接使用交换法
    public static void shellSort01(int[] arr) {
        int temp = 0;// 用于交换
        // 第一层循环，将待排序数组进行分组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 第二层循环，遍历分好组的数组
            for (int i = gap; i < arr.length; i++) {
                // 第三层循环，遍历各组中所有的元素（共gap组），步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
}
