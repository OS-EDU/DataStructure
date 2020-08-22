package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-08-22 15:26
 */
public class ShellSort {

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
