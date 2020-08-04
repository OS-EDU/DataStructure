package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-08-04 15:10
 */
public class BubbleSort {


    // 冒泡排序方法
    public static void bubbleSort(int[] arr) {
        int temp = 0;// 临时变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
