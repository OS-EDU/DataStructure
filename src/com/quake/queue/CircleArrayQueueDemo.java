package com.quake.queue;

import java.util.Scanner;

/**
 * @author AKA二夕
 * @create 2020-05-23 10:18
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);// 说明设置4，其队列的有效数据最大是3
        char key = ' ';// 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：查看头队列的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.show();
                    break;
                case 'a':
                    System.out.print("请输入需要添加的数据：");
                    int val = scanner.nextInt();
                    circleArray.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列的头元素是：%d\n", res);
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
        System.out.println("退出程序！");
    }
}

class CircleArray {
    private int maxSize;// 表示数组的最大容量
    private int front;// 指向队列的第一个元素，初始值是0，也就是队列的第一个元素
    private int rear;// 指向队列的最后一个元素的后一个位置，空出一个位置作为约定，初始值为0
    private int[] arr;// 该数组用于存放数据，模拟队列

    // 构造器
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    // 判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 添加数据入队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("该队列已满，，无法添加任何数据~");
            return;
        }
        arr[rear] = n;// 直接将数据加入
        rear = (rear + 1) % maxSize;// 将rear后移，这里必须考虑取模
    }

    // 从队列中取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("该队列为空，无任何数据可以取出~");
        }
        /*
            注：这里front是指向队列的第一个元素，所以在取出数据时要做以下处理
            1、先把front对应的值保留到一个临时变量
            2、将front后移，考虑取模
            3、将临时保存的变量返回
         */
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    // 显示队列的所有数据
    public void show() {
        if (isEmpty()) {
            System.out.println("该队列为空，无任何数据可以显示~");
            return;
        }
        // 遍历时，从front开始遍历，遍历元素为 front+有效数据的个数
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("该队列为空，无头数据可显示~");
        }
        return arr[front];
    }

}