package com.quake.stack;

import java.util.Scanner;
/**
 * @author AKA二夕
 * @create 2020-06-17 14:01
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        String key = "";// 接收用户输入的指令
        boolean loop = true;// 控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：添加数据到栈中（入栈）");
            System.out.println("pop：从栈中取出数据（出栈）");
            System.out.println("请输入您的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.println("出栈的数据是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出程序~~~");
    }
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
