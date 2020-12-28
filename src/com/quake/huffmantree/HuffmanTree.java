package com.quake.huffmantree;

import java.time.temporal.ValueRange;

/**
 * @author AKA二夕
 * @create 2020-12-28 15:16
 */
public class HuffmanTree {
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
