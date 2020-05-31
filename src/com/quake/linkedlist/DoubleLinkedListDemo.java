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
    // 先初始化一个结点，头结点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 添加一个结点到双向链表的最后
    public void add(HeroNode2 heroNode2) {
        // 因为head结点不能动，因此我们需要添加一个辅助变量temp
        HeroNode2 temp = head;
        // 遍历链表，知=找到链表的最后
        while (true) {
            if (temp.next == null) {// 遍历到链表的最后
                break;
            }
            // 如果没有找到将temp后移
            temp = temp.next;// 后移
        }
        // 当退相互while循环时，temp就指向了链表的最后
        // 形成了一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    // 遍历打印输出链表信息
    public void show() {
        // 先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 因为头结点不能动，定义一个辅助变量用于遍历
        HeroNode2 temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出结点信息
            System.out.println(temp);
            temp = temp.next;// 将temp后移！！！
        }
    }
}

// 定义HeroNode2，每个HeroNode2对象就是一个对象
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 pre;// 指向下一个结点，默认为null
    public HeroNode2 next;// 指向前一个结点，默认为null

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，重写toString
    @Override
    public String toString() {
        return "HeroNode2{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", nickname=" + nickname +
                '}';
    }
}