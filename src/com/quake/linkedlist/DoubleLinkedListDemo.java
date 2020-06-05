package com.quake.linkedlist;

/**
 * @author AKA二夕
 * @create 2020-05-30 11:12
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        System.out.println("原始的双向链表信息如下：");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.show();

        System.out.println("修改之后的双向链表信息如下：");
        HeroNode2 newHeroNode2 = new HeroNode2(2, "卢员外", "玉麒麟2.0");
        doubleLinkedList.update(newHeroNode2);
        doubleLinkedList.del(3);
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
        // 当退出while循环时，temp就指向了链表的最后
        // 形成了一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    // 根据编号顺序添加结点
    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode2.no) {
                break;
            } else if (temp.next.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("需要插入的英雄编号%d已存在，添加失败\n", heroNode2.no);
        } else {
            heroNode2.next = temp.next;// 将新插入的结点指向它的下一个结点
            heroNode2.pre = temp;// 将新插入的结点指向它的前一个结点
            // 注：如果不是最后一个结点，则不需要执行下面这块代码，否则会出现空指针
            if (temp.next != null) {
                temp.next.pre = heroNode2;
            }
            temp.next = heroNode2;
        }
    }

    // 编写添加测试方法
    public void addOrder(HeroNode2 heroNode2){
        HeroNode2 temp = head ;
        while(true){
            if(temp.next == null){
                temp.next = heroNode2;
                heroNode2.pre = temp ;
                break ;
            }else if (temp.next.no > heroNode2.no){//表示找到了插入点
                heroNode2.next = temp.next ;
                heroNode2.pre = temp;
                temp.next.pre = heroNode2 ;
                temp.next = heroNode2 ;
                break ;
            }else if(temp.no == heroNode2.no){
                System.out.printf("插入节点的编号%d 已经存在 \n" , heroNode2.no);

            }
            temp = temp.next ;
        }
    }

    // 修改结点信息（可以看待双向链表的结点内容修改和单向链表一样）
    public void update(HeroNode2 newHeroNode2) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的结点，根据no编号
        HeroNode2 temp = head.next;// 定义一个辅助变量
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode2.no) {// 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到需要修改的节点
        if (flag) {
            temp.name = newHeroNode2.name;
            temp.nickname = newHeroNode2.nickname;
        } else {//没有找到
            System.out.printf("没有找到 编号%d的节点，不能修改", newHeroNode2.no);
        }
    }

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int no) {
        // 判断当前链表是否为空
        if (head.next == null) {// 空链表
            System.out.println("链表为空，无法删除~");
            return;
        }
        HeroNode2 temp = head.next; // 辅助变量(指针)
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp == null) { // 已经到链表的最后
                break;
            }
            if (temp.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; // temp后移，遍历
        }
        // 判断flag
        if (flag) { // 找到
            // 可以删除
            temp.pre.next = temp.next;
            // 如果是最后一个结点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
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