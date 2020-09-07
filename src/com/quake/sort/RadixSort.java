package com.quake.sort;

import java.util.Arrays;

/**
 * @author AKA二夕
 * @create 2020-09-04 22:15
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        System.out.println("排序之前的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序之后的数组顺序如下：");
        System.out.println(Arrays.toString(arr));
    }

    // 基数排序方法
    public static void radixSort(int[] arr) {
        // 得到数组中最大的数的位数
        int max = arr[0];// 假设第一位数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 得到的最大数就是几位数
        int maxLength = (max + "").length();

        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        /*
            说明：
                1、二维数组包含10个一维数组
                2、为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定位arr.length
                3、基数排序是使用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];

        // 再定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 针对各个元素的对应位进行排序处理，第一次是个位，第二次是十位，以此类推
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素对应位的值
                int digitOffElement = arr[j] / n % 10;
                // 放入对应的桶中
                // 比如：53和3 这两个数，所对应的就是bucket[3][2] 表示的意思就是 个位数字为3的桶中有两个数
                // 其中digitOfElement对应的是3（个位数字），bucketElementCounts[digitOfElement]用于记录对应桶中的个数
                bucket[digitOffElement][bucketElementCounts[digitOffElement]] = arr[j];
                bucketElementCounts[digitOffElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入到原来的数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（第k个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }
    }
}
