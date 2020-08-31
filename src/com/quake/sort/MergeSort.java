package com.quake.sort;

import java.util.Arrays;

/**
 * @author AKA二夕
 * @create 2020-08-31 15:29
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        System.out.println("原始的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序之后的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
    }

    // 分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;// 中间索引
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr   待排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param right 右边有序序列的初始索引
     * @param mid   中间索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;// 初始化i，左边有序序列的初始索引
        int j = mid + 1;// 初始化j，右边有序序列的初始索引
        int t = 0;// 指向temp数组的当前索引

        /*
            （一）
            先把左右两边（有序）的数据按照规则填充到temp数组
            直到左右两边的有序序列，有一边处理完毕为止。
         */
        while (i <= mid && j <= right) {
            // 如果左边的有序序列的当前元素，相遇等于右边有序序列的当前元素
            // 即 将左边的当前元素，填充到temp数组
            // 然后 t++ i++ 后移
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {// 反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        /*
            （二）
            把有剩余数据的一边的数据依次全部填充到temp
         */
        while (i <= mid) {// 处理左边有序序列的剩余数据
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {// 处理右边有序序列的剩余数据
            temp[t] = arr[j];
            t++;
            j++;
        }

        /*
            （三）
            将temp数组的元素拷贝到arr
            注意：并不是每次都要拷贝所有！！！
         */
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
