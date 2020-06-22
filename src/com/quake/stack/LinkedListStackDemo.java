package com.quake.stack;

/**
 * @author AKA二夕
 * @create 2020-06-22 19:38
 */
public class LinkedListStackDemo {
}

// 定义一个类表示结点
class StackNode {
    public int data;// data域用于存储数据
    public StackNode next;// next域用于链接下一个结点

    // 构造器
    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                '}';
    }
}
