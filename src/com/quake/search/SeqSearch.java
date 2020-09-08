package com.quake.search;

/**
 * @author AKA二夕
 * @create 2020-09-08 9:39
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 22, -1, 43, 293};
        int index = seqSearch(arr, -1);
        if (index == -1) {
            System.out.println("没有找到对应的值");
        } else {
            System.out.printf("找到arr[%d] = %d", index, arr[index]);
        }
    }

    // 这里实现的线性查找是找到一个满足条件的值，就返回
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是注意逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
