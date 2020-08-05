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

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种解法",count);
        System.out.printf("一共判断冲突的次数%d次",judgeCount);
    }

    // 方法：放置第n个皇后
    // 特别注意：check是每一次递归时，进入到check中都有for(int i = 0; i < max; i++)，因此会有回溯
    private void check(int n) {
        if (n == max) {// n = 8 时，表示8个皇后已经全部安放好
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前的这个皇后n，放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {// 不冲突
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i;即将第n个皇后放置在本行的后移的一个位置
        }
    }

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
                1、array[i] == array[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
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
