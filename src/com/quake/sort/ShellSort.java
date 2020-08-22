package com.quake.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

        int[] str = new int[80000];
        for (int i = 0; i < 80000; i++) {
            str[i] = (int)(Math.random() * 90000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为："+date1Str);

        shellSort02(str);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为："+date2Str);
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

    // 对交换式的希尔排序进行优化 ——> 移位法
    public static void shellSort02(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
