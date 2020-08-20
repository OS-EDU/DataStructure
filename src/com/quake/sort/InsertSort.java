package com.quake.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author AKA二夕
 * @create 2020-08-20 15:16
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        System.out.println("排序之前的数组如下：");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序之后的数组顺序如下：");
        System.out.println(Arrays.toString(arr));

        int[] str = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            str[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println(date1Str);
        insertSort(str);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println(date2Str);
    }

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
