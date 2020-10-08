package com.quake.tree;

/**
 * @author AKA二夕
 * @create 2020-10-08 20:00
 */
public class HeapSort {

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     * 功能：完成将以i对应的非叶子结点的树，调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中的索引
     * @param length 表示对应多少个元素继续调整，length是在逐渐的减少
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
