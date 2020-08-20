package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-08-20 15:16
 */
public class InsertSort {

    // 直接插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
