package com.quake.stack;

/**
 * @author AKA二夕
 * @create 2020-06-17 14:01
 */
public class ArrayStackDemo {
}

// 定义一个ArrayStack表示栈
class ArrayStack {
    private int maxSize;// 栈的大小
    private int[] stack;// 数组，数组模拟栈，数据就在该数组
    private int top = -1;// top表示栈顶，初始化为-1

    // 构造器
    public ArrayStack(int maxSize) {
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

    // 入栈——push
    public void push(int value) {
        // 先判断栈是否未满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈——pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~~~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈，遍历时，需要从栈顶开始显示数据
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空，没事有数据~~~");
            return;
        }
        // 需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
