package com.quake.stack;

/**
 * @author AKA二夕
 * @create 2020-06-22 19:38
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        StackNode node1 = new StackNode(1);
        StackNode node2 = new StackNode(2);
        StackNode node3 = new StackNode(3);
        StackNode node4 = new StackNode(4);
        LinkedListStack linkedListStack = new LinkedListStack();
        System.out.println("原始的链栈信息如下：");
        linkedListStack.push(node1);
        linkedListStack.push(node2);
        linkedListStack.push(node3);
        linkedListStack.push(node4);
        linkedListStack.show();
        System.out.println("有效的结点个数为："+linkedListStack.getSize());

        System.out.println("修改之后的链栈信息如下：");
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.show();
        System.out.println("有效的结点个数为："+linkedListStack.getSize());
    }
}

// 定义一个类用于管理结点
class LinkedListStack {
    private StackNode top = new StackNode(0);// 定义一个头结点，表示栈顶
    private int size;

    // 初始化
    public LinkedListStack() {
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
        while (temp != null) {
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
