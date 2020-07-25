package com.quake.recursion;

/**
 * @author AKA二夕
 * @create 2020-07-25 22:19
 */
public class Fibonacci {
    public static void main(String[] args) {
        int[] a = new int[13];
        a[0] = 0;
        a[1] = 1;
        System.out.println("a[0] = " + a[0]);
        System.out.println("a[1] = " + a[1]);
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 1] + a[i - 2];
            System.out.println(a[i]);
        }

        // 使用递归计算
        for (int i = 0; i < a.length; i++) {
            System.out.printf("第%d个月兔子总数为：%d", i, Fbi(i));
            System.out.println();
        }
    }

    // 使用递归的方法处理
    public static int Fbi(int i) {
        if (i < 2) {
            return i == 0 ? 0 : 1;
        } else {
            return Fbi(i - 1) + Fbi(i - 2);
        }
    }
}
