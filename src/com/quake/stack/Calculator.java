package com.quake.stack;

/**
 * @author AKA二夕
 * @create 2020-07-01 16:01
 */
public class Calculator {
}

// 定义一个ArrayStack2 表示栈
class ArrayStack2 {
    private int[] stack;// 数组，用于模拟栈，数据就存放在该数组
    private int maxSize;// 栈的大小
    private int top = -1;// 表示栈顶，初始化为-1

    // 构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈 —— push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 —— pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~~~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 增加一个方法，可以返回当前栈顶的值，但不是真正的top
    public int peek() {
        return stack[top];
    }
}