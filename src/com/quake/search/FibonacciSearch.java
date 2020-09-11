package com.quake.search;

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
}
