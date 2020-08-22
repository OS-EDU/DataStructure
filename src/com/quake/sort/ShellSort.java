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

    // 希尔排序 使用交换法
    public static void shellSort01(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
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
