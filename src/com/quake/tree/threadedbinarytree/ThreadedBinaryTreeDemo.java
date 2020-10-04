package com.quake.tree.threadedbinarytree;

/**
 * @author AKA二夕
 * @create 2020-10-04 13:36
 */
public class ThreadedBinaryTreeDemo {
}

// 创建HeroNode结点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;// 默认为null
    private HeroNode right;// 默认为null

    // 构造器
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
