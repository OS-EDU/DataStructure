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

    // 判断是否是运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 返回运算符的优先级，优先级是由程序猿来确定的，使用数字表示
    // 这里规定：优先级越高，返回的数字越大
    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;// 假定目前表达式的运算符只有+、-、*、/
        }
    }

    // 计算方法
    public int cal(int num1, int num2, char oper) {
        int res = 0;// res用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}