package com.quake.stack;

/**
 * @author AKA二夕
 * @create 2020-06-22 19:38
 */
public class LinkedListStackDemo {
}

// 定义一个类用于管理结点
class LinkedListStack {
    private StackNode top = new StackNode(0);// 定义一个头结点，表示栈顶
    private int size;

    // 初始化
    private LinkedListStack() {
        top = null;
        size = 0;
    }

    // 判断链栈是否为空
    public boolean isEmpty() {
        return top == null;
    }

    // 获取size的大小
    public int getSize() {
        return size;
    }

    // 入栈 —— push
    public void push(StackNode stackNode) {
        stackNode.next = top;
        top = stackNode;
        size++;
    }

    // 出栈 —— pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("链栈为空~~");
        }
        StackNode temp = top;// 辅助变量
        top = temp.next;
        int retValue = temp.data;// 定义一个临时变量，用于保存栈顶元素
        temp = null;// 将temp置空
        size--;
        return retValue;
    }

    // 显示栈中信息
    public void show() {
        if (isEmpty()) {
            System.out.println("链栈为空~~");
            return;
        }
        StackNode temp = top;
        if (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
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
