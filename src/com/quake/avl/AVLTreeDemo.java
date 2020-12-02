package com.quake.avl;

/**
 * @author AKA二夕
 * @create 2020-12-02 16:08
 */
public class AVLTreeDemo {
}

// 创建Node类表示结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
