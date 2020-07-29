package com.quake.recursion;

/**
 * @author AKA二夕
 * @create 2020-07-29 15:11
 */
public class Queen8 {
    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后放置位置的结果
    int[] array = new int[max];
    static int count;// 统计解法
    static int judgeCount;// 统计回溯的次数

    // 输出皇后摆放的位置
    private void print() {
        count++;// 每输出一次解法，count + 1
        for (int value : array) {
            System.out.print(value + "   ");
        }
        System.out.println();// 换行
    }
}
