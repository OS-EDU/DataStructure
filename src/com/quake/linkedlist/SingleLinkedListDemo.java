package com.quake.linkedlist;

/**
 * @author AKA二夕
 * @create 2020-05-24 16:22
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        System.out.println("原始的链表信息如下：");
        singleLinkedList.show();

        System.out.println("修改之后的结点信息如下：");
        singleLinkedList.del(3);// 删除结点
        HeroNode newHeroNode = new HeroNode(2, "卢员外", "玉麒麟2.0");
        singleLinkedList.update(newHeroNode);// 修改结点信息
        singleLinkedList.show();

    }
}

//定义SingleLinkedList管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加数据到单向链表
    /*
     * 思路：当不考虑编号顺序时
     * 1、找到当前链表的最后的节点
     * 2、将最后这个节点的next指向新的节点
     * */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //第二种方式添加英雄，根据排名将英雄插入到指定位置
    //注：如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此仍然需要通过一个辅助指针（变量）来帮助找到添加的位置
        //因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no >= heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode编号已经存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号已经存在
            System.out.printf("准备插入的英雄编号%d已经存在，添加失败\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据num编号来修改，即num编号不能改
    //1、根据newHeroNode的num来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //2、找到需要修改的节点，根据num编号修改
        HeroNode temp = head.next;//定义一个辅助变量
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//已经遍历结束
            }
            if (temp.no == newHeroNode.no) {//找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //3、根据flga，判断是否找到需要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {//没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    /*
     * 思路：
     * 1、head不能动，因此需要一个temp的节点找到待删除节点的前一个节点
     * 2、说明在比较时，是temp.next,num和需要删除的节点的no进行比较
     * */
    public void del(int num) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp.next == null) {
                break;//已经到链表的最后
            }
            if (temp.next.no == num) {//找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判断flag
        if (flag) {//找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("需要删除的%d节点不存在\n", num);
        }
    }

    //显示链表，遍历
    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {// 判断是否到链表最后
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}
// 定义HeroNode，每个HeroNode对象就是一个结点
class HeroNode {
    public int no;// 编号
    public String name;// 姓名
    public String nickname;// 昵称
    public HeroNode next;// next域，指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 利用toString显示信息
    @Override
    public String toString() {
        return "HeroNode{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", nickname=" + nickname +
                '}';
    }
}