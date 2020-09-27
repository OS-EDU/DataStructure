package com.quake.tree;

/**
 * @author AKA二夕
 * @create 2020-09-27 22:01
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历结果如下：");
        arrBinaryTree.preOrder();
        System.out.println("中序遍历结果如下：");
        arrBinaryTree.infixOrder();
    }

}

// 编写一个类，实现顺序存储二叉树遍历
class ArrBinaryTree {
    private int[] arr;// 纯属数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    // 重载infixOrder
    public void infixOrder() {
        this.infixOrder(0);
    }

    // 重载postOrder
    public void postOrder() {
        this.postOrder(0);
    }

    /**
     * 编写一个方法，实现顺序存储二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        // 先判断数组是否为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法完成相关遍历");
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    // 顺序存储二叉树的中序遍历
    public void infixOrder(int index) {
        // 先判断数组是否为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法完成相关遍历");
        }
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    // 顺序存储二叉树的后序遍历
    public void postOrder(int index) {
        // 先判断数组是否为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法完成相关遍历");
        }
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
    }
}