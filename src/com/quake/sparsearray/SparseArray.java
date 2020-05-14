package com.quake.sparsearray;

/**
 * @author AKA二夕
 * @create 2020-05-14 8:50
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 10*10
        // 0表示没有棋子，1表示黑子，2表示白子
        int chessArr1[][] = new int[10][10];
        chessArr1[1][3] = 1;
        chessArr1[1][4] = 2;
        chessArr1[2][3] = 1;
        chessArr1[0][3] = 2;

        // 输出原始的原始的二维数组
        System.out.println("原始的二维数组如下：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转化为稀疏数组
        // 1、先遍历二维数组，记录非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 10;
        sparseArr[0][1] = 10;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;// count用于记录是第几个非0数据
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println("-----------------------------------------");// 分割线
        System.out.println("得到的稀疏数组如下：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println("-----------------------------------------");// 分割线

        // 将稀疏数组恢复成原始的二维数组
        // 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2、再读取稀疏数组后几行的数据（从第二行开始）
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println("恢复后的二维数组如下：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
