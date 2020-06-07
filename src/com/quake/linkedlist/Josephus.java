package com.quake.linkedlist;

/**
 * @author AKA二夕
 * @create 2020-06-06 15:09
 */
public class Josephus {
}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    private Boy first = null;

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
