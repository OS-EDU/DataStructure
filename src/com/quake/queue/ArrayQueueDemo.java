package com.quake.queue;

import java.util.Scanner;

/**
 * @author AKA二夕
 * @create 2020-05-17 20:21
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';// 接受用户输入的菜单
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看头队列的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.printf("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("头部数据为：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出循环");
    }
}

// 使用数组模拟队列，编写一个叫做ArrayQueue的类
class ArrayQueue {
    private int maxSize;// 表示数组的最大容量
    private int front;// 队列头
    private int rear;// 队列尾
    private int[] arr;// 该数组用于存放数据，模拟队列

    // 创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;// 指向队列头部，front是指向队列头的前一个位置
        rear = -1;// 指向队列的尾部，rear是队列最后一个数据
    }

    // 判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 首先判断队列是否为满
        if (isFull()) {
            System.out.println("该队列已满，无法添加任何数据~");
            return;
        }
        rear++;// 让rear后移
        arr[rear] = n;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 首先判断队列是否为空
        if (isEmpty()) {// 这里可以通过抛出异常处理
            throw new RuntimeException("该队列为空，无法取出任何数据");
        }
        front++;// 让front后移
        return arr[front];
    }

    // 显示队列所有数据
    public void showQueue() {
        // 先判断是否为空
        if (isEmpty()) {
            System.out.println("该队列为空，无数据可显示~");
            return;
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示头队列的信息，注意不是取出数据
    public int headQueue() {
        // 先判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据可显示");
        }
        return arr[front + 1];
    }
}
