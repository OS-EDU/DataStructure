package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-08-20 15:16
 */
public class InsertSort {

    // 直接插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];// 定义待插入的数
            int insertIndex = i - 1;// 即arr[i]的前面的这个数的下标

            /*
            给insertVal找到插入的位置
            说明：
                1、insertIndex >= 0 保证在给insertVal找插入位置，不越界
                2、insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
                3、需要将arr[insertIndex] 后移
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex + 1
            //判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
