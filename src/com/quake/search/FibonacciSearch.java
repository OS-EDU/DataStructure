package com.quake.search;

import java.util.Arrays;

/**
 * @author AKA二夕
 * @create 2020-09-11 19:42
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    // 先获取一段斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    // 编写斐波那契查找算法

    /**
     * 使用非递归的方式编写算法
     *
     * @param arr 查找表（数组）
     * @param key 需要查找的关键字
     * @return 返回对应的下标，如果没有返回 -1
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//  表示斐波那契分割数值的下标
        int mid = 0;// 存放mid值
        int[] f = fib();// 获取斐波那契数列

        // 获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        // 因为f[k]值可能会大于arr的长度，因此需要一个Arrays类，构造一个新的数组，并指向temp[]
        // 不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 将不满的数值补全
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];

        }

        // 使用while循环来处理。找到数值key
        while (low < high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {// 应该继续向数组前面查找（左边）
                high = mid - 1;
                k -= 1;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
