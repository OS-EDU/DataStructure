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
    }
}
