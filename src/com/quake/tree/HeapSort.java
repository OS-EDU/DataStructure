package com.quake.tree;

import java.util.Arrays;

/**
 * @author AKA二夕
 * @create 2020-10-08 20:00
 */
public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排序
        int[] arr = {4, 6, 8, 5, 9, -1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 编写一个堆排序的方法
    public static void heapSort(int[] arr) {
        int temp = 0;

        // 1、将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 2、将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        // 3、重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整，直到整个序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            // 交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     * 功能：完成将以i对应的非叶子结点的树，调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中的索引
     * @param length 表示对应多少个元素进行调整，length是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];// 先取出当前元素的值，保存在临时变量

        // 说明：k = i * 2 + 1 k是i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;// k指向右子结点
            }
            if (arr[k] > temp) {// 如果子结点大于父结点
                arr[i] = arr[k];// 把较大的值赋给当前结点
                i = k;// i指向k，继续循环比较
            } else {
                break;
            }
        }
        // 当for循环结束后，已经将i为父结点的树的最大值，放在了最顶（局部）
        arr[i] = temp;// 将temp值放到调整后的位置
    }
}
