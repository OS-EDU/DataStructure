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

    // 查看当放置第n个皇后，检测该皇后是否和前面已经摆放的皇后冲突

    /**
     * @param n 表示第n个皇后
     * @return 如果不冲突返回true，否则返回false
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            /*
            说明：
                1、array[i] == array[n] 示判断第n个皇后是否和前面的n-1个皇后在同一列
                2、Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i个皇后在同一斜线
             */
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    // 输出皇后摆放的位置
    private void print() {
        count++;// 每输出一次解法，count + 1
        for (int value : array) {
            System.out.print(value + "   ");
        }
        System.out.println();// 换行
    }
}
