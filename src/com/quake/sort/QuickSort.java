package com.quake.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author AKA二夕
 * @create 2020-08-27 21:11
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        System.out.println("排序之前的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序之后的数组顺序如下：");
        System.out.println(Arrays.toString(arr));

        int[] str = new int[80000];
        for (int i = 0; i < str.length; i++) {
            str[i] = (int) (Math.random() * 900000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为：" + date1Str);

        quickSort(str, 0, str.length - 1);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为：" + date2Str);
    }

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
            // 如果 l >= r 说明pivot左边的值，已经全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后，发现 arr[l] == pivot值相等，r-- 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            // 如果交换完后，发现arr[r] == pivot值相等，l++ 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r ， 必须l++、r--，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
