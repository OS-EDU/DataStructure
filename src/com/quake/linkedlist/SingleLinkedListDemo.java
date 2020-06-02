package com.quake.linkedlist;

import java.util.Stack;

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

        System.out.println("测试getLength方法");
        System.out.println("该链表的有效结点个数是：" + getLength(singleLinkedList.getHead()));

        System.out.println("测试findLastIndexNode方法");
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("res = " + res);

        System.out.println("测试reversePrint方法");
        reversePrint(singleLinkedList.getHead());

        System.out.println("测试reversList方法");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.show();
    }

    // 获取单链表的有效结点（如果是带头结点的，需要不统计头结点的信息）
    // head链表的头结点，返回的就是有效结点的个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {// 链表为空
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;// 定义一个辅助变量
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // 查找单链表中的倒数第K个结点
    /*
    思路：
        1、编写一个方法，接收head结点，同时接受一个index
        2、index表示是倒数第index个结点
        3、先把链表从头到尾遍历，得到链表的总长度getLength
        4、得到size后，然后从链表第一个开始遍历（size - index）个，就可得到
        5、如果找到了，则返回该结点，否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 判断链表是否为空，如果是则返回null
        if (head.next == null) {
            return null;// 没有找到
        }
        // 第一次遍历得到链表对的长度（结点个数）
        int size = getLength(head);
        // 先做一个index校验
        if (index < 0 || index > size) {
            return null;
        }
        // 定义一个辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next;
        // 第二次遍历 size - index位置，就是倒数的第k个结点
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 将单链表反转
    /*
    思路：
        1、先定义一个结点 reverseHead = new HeroNode();
        2、从头到尾遍历原来的链表，每遍历一个结点，将其取出，并放在新的链表reverseHead的最前端
        3、原来的链表的 head.next = reverseHead.next;
     */
    public static void reverseList(HeroNode head) {
        // 如果当前链表为空，或者只有一个结点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;// 定义一个辅助变量，帮助遍历原来的链表
        HeroNode nextNode = null;// 指向当前结点[cur]的下一个结点
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表，每遍历一个结点，将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            nextNode = cur.next;// 先暂时保存当前结点的下一个结点，
            cur.next = reverseHead.next;;// 将cur的下一个结点指向新的链表的最前端
            reverseHead.next = cur;// 将cur连接到新的链表上
            cur = nextNode;// 让cur后移
        }
        // 将 head.next 指向 reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    // 从尾到头打印单链表
    // 利用栈，将各个结点压入到栈中，然后利用栈的先进后出的特点，从而可以实现逆序打印的效果
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;// 空链表，不能打印
        }
        // 创建一个栈，将各个结点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 将链表的所有结点压入到栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 将栈中的结点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());// stack的特点就是先进后出
        }
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

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //1、根据newHeroNode的no来修改即可
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
        //3、根据flag，判断是否找到需要修改的节点
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
     * 2、说明在比较时，是temp.next,no和需要删除的节点的no进行比较
     * */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp.next == null) {
                break;//已经到链表的最后
            }
            if (temp.next.no == no) {//找到待删除节点的前一个节点temp
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
            System.out.printf("需要删除的%d节点不存在\n", no);
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