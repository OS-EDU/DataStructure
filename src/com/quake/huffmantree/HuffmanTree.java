package com.quake.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author AKA二夕
 * @create 2020-12-28 15:16
 */
public class HuffmanTree {

    /**
     * 创建哈夫曼树的方法
     *
     * @param arr 需要创建哈夫曼树的数组
     * @return 创建好后的哈夫曼树的root结点
     */
    public static Node createHuffmanTree(int[] arr) {
        /**
         * 1、遍历arr数组；
         * 2、将arr的每个元素构成一个Node
         * 3、将Node放入到ArrayList中
         */
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        // 进行循环处理
        while (nodes.size() > 1) {
            // 排序 从小到大
            Collections.sort(nodes);

            System.out.println("nodes = " + nodes);

            // 取出根结点权值最小的两棵二叉树
            // 1、取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            // 2、取出权值第二小的结点（二叉树）
            Node rightNode = nodes.get(1);
            // 3、构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4、从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5、将parent结点加入到nodes中
            nodes.add(parent);
        }
        // 返回哈夫曼树的root结点
        return nodes.get(0);
    }
}


// 创建类结点
// 为了让Node对象持续排序 Collections 集合排序，实现 Comparable 接口
class Node implements Comparable<Node> {
    int value;// 结点权值
    char c;// 字符
    Node left;// 指向左子结点
    Node right;// 指向右子结点

    // 构造器
    public Node(int value) {
        this.value = value;
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node node) {
        // 表示从小到大排序
        return this.value - node.value;
    }
}
