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
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize -1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }
}
