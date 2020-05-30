package com.quake.linkedlist;

/**
 * @author AKA二夕
 * @create 2020-05-30 11:12
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.show();
    }
}

// 定义一个类管理结点
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0,"","");

    // 添加数据
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {// 遍历到链表的最后
                break;
            }
            temp = temp.next;// 后移
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    // 遍历打印输出链表信息
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

// 定义一个双向链表结点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", nickname=" + nickname +
                '}';
    }
}