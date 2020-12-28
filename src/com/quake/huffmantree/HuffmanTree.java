package com.quake.huffmantree;

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

    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }
}
