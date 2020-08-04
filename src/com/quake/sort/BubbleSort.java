package com.quake.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author AKA二夕
 * @create 2020-08-04 15:10
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] str = {3, 9, -1, 10, -2};
        System.out.print("排序前的数组是：");
        System.out.println(Arrays.toString(str));
        bubbleSort(str);
        System.out.print("排序之后的数组是：");
        System.out.println(Arrays.toString(str));

        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            // 随机生成80000个数字
            arr[i] = (int)(Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是："+date1Str);

        //测试冒泡排序
        bubbleSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+dateStr2);
    }


    // 冒泡排序方法
    public static void bubbleSort(int[] arr) {
        boolean flag = false;// 标识符
        int temp = 0;// 临时变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {// 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false;// 重置flag进行下次判断
            }
        }
    }
}
