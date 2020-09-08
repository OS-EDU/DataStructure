package com.quake.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AKA二夕
 * @create 2020-09-08 10:32
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 45, 67, 88, 198, 198, 198, 245};
        int i = binarySearch01(arr, 0, arr.length - 1, 198);
        System.out.println("i = " + i);
        List<Integer> resIndexList = binarySearch02(arr, 0, arr.length - 1, 198);
        System.out.println("resIndexList = " + resIndexList);
        int j = binarySearch01(arr, 0, arr.length - 1, 23);
        System.out.println("i = " + j);
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

        if (findVal > arr[mid]) {// 向右递归
            return binarySearch01(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {// 向左递归
            return binarySearch01(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    /*
    思考：当有多个相同数值时，如何将所有的数值都查找到
    思路分析：
        1、当找到mid索引值时，不要立刻返回；
        2、向mid索引值的左边扫描,将所有满足元素的下标，加入到集合ArrayList
        3、向mid索引值的右边扫描，将所有满足元素的下标，加入到集合ArrayList
        4、将ArrayList返回
     */
    public static List<Integer> binarySearch02(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (right + left) / 2;
        int midVal = arr[mid];

        if (findVal > arr[mid]) {
            return binarySearch02(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch02(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            // 向mid索引值左边扫描，将所有满足元素的下标，加入到集合ArrayList中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {// 没有找到，退出
                    break;
                }
                // 否则，将temp放入到resIndexList中
                resIndexList.add(temp);
                temp--;// temp左移
            }

            resIndexList.add(mid);

            // 向mid索引值右边扫描，将所有满足元素的下标，加入到集合ArrayList中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;// temp右移
            }
            return resIndexList;
        }
    }

    // 非递归实现折半查找
    public static int binarySearch03(int[] arr, int left, int right, int findVal) {
        int mid = 0;
        int midVal = arr[mid];
        while (left <= right) {
            mid = (left + right) / 2;
            if (findVal < midVal) {
                right = mid - 1;
            } else if (findVal > midVal) {
                left = mid + 1;
            } else {
                return -1;
            }
        }
        return mid;
    }
}
