package com.quake.hashtab;

/**
 * @author AKA二夕
 * @create 2020-09-13 14:37
 */
public class HashTabDemo {
}

// 表示一个雇员
class Emp {
    public int id;// 编号
    public String name;// 姓名
    public Emp next;// next默认为null

    // 构造器
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 创建EmpLinkedList，表示链表
class EmpLinkedList {
    // 头指针，执行第一个Emp。因此这个链表的head是指向第一个Emp
    private Emp head;// 默认为null

    /*
    添加雇员到链表：
        说明：
           假定，当添加雇员时，id是自增长的，即id的分配总是从小到大
           因此将雇员直接加入到本链表的最后即可
     */
    public void add(Emp emp) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        // 如果不是第一个雇员，则需要一个辅助指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp == null) {// 说明遍历到链表的最后
                break;
            }
            // 后移
            curEmp = curEmp.next;
        }
        // 退出时，直接将emp加入到链表
        curEmp.next = emp;
    }

}