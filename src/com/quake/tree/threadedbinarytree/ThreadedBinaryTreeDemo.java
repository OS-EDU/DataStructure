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

    /*
    说明：
        1、如果leftType == 0 表示指向的是左子树，如果1则表示是前驱结点
        2、如果rightType == 0 表示指向的是右子树，如果1则表示指向后继结点
     */
    private int leftType;
    private int rightType;

    // 构造器
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                " name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
