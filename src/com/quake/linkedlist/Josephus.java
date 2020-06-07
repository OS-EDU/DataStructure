package com.quake.linkedlist;

/**
 * @author AKA二夕
 * @create 2020-06-06 15:09
 */
public class Josephus {
}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first结点，当前没有编号
    private Boy first = null;

    // 添加小孩结点，构建一个环形的链表，nums表示需要添加结点的个数
    public void addBoy(int nums) {
        if (nums < 1) {//检验
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;// 辅助指针，帮助构建环形链表
        // 使用for循环俩创建环形链表
        for (int i = 1; i < nums; i++) {
            // 根据编号，创建小孩结点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);// 构成环
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
}

// 创建一个Boy类，表示一个结点
class Boy {
    private int no;// 编号
    private Boy next;// 指向下一个结点，默认为null

    // 构造器
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
