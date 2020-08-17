package com.quake.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

        int[] str = new int[80000];
        for (int i = 0; i < str.length; i++) {
            str[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为：" + date1Str);

        selectSort(str);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序之后的时间为：" + date2Str);
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
