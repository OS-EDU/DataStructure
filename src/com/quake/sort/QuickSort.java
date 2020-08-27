package com.quake.sort;

/**
 * @author AKA二夕
 * @create 2020-08-27 21:11
 */
public class QuickSort {

    // 快速排序
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;// 左下标
        int r = right;// 右下标
        int pivot = arr[(left + right) / 2];// 中轴值
        int temp = 0;// 临时变量

        // while循环的目的是让比pivot值小放到左边，比pivot值大放到右边
        while (l < r) {
            // 在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 如果 l >= r 说明pivot的左右两边的值，已经全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

    }
}
