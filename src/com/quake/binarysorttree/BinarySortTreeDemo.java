package com.quake.binarysorttree;

/**
 * @author AKA二夕
 * @create 2020-10-31 23:13
 */
public class BinarySortTreeDemo {
}


// 创建Node结点
class Node {
    private int value;
    private Node left;
    private  Node right;

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