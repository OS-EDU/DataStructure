package com.quake.search;

/**
 * @author AKA二夕
 * @create 2020-09-08 10:32
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 45, 67, 88, 198, 198, 198, 245};
        int i = binarySearch01(arr, 0, arr.length - 1, 198);
        System.out.println("i = " + i);
    }

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 需要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回-1
     */
    public static int binarySearch01(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归完整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > arr[mid]) {
            return binarySearch01(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch01(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
