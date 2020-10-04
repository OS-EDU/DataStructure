package com.quake.tree.threadedbinarytree;

/**
 * @author AKA二夕
 * @create 2020-10-04 13:36
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把终须线索二叉树的功能
        HeroNode root = new HeroNode(1, "Tom");
        HeroNode node2 = new HeroNode(3, "Jack");
        HeroNode node3 = new HeroNode(6, "Smith");
        HeroNode node4 = new HeroNode(8, "Mary");
        HeroNode node5 = new HeroNode(10, "King");
        HeroNode node6 = new HeroNode(14, "Dim");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10号结点的后继结点是=" + rightNode); //1
    }

}

// 定义ThreadedBinaryTree
class ThreadedBinaryTree {
    private HeroNode root;

    // 为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    // 在递归进行线索化时，pre总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载threadNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    public void threadedNodes(HeroNode node) {
        // 如果node == null 不能线索化
        if (node == null) {
            return;
        }

        // （一）先线索化左子树
        threadedNodes(node.getLeft());

        // （二）线索化当前结点【难点】
        // 处理当前结点的前驱结点
        if (node.getLeft() == null) {
            // 当前结点的左指针
            node.setLeft(pre);
            // 修改当前结点的左指针的类型，指向前驱结点
            node.setLeftType(1);
        }
        // 处理后继结点
        if (pre != null && pre.getRight() == null) {
            // 让前驱结点的右指针指向当前结点
            pre.setRight(node);
            // 修改前驱结点的右指针类型
            node.setRightType(1);
        }
        // ！！！每处理一个结点后。让当前结点指向下一个结点的前驱结点
        pre = node;

        // （三）再线索化右子树
        threadedNodes(node.getRight());
    }
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
