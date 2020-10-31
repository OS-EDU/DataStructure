package com.quake.binarysorttree;

/**
 * @author AKA二夕
 * @create 2020-10-31 23:13
 */
public class BinarySortTreeDemo {
}


// 创建Node结点
class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    // 添加结点的方法，以递归的形式添加结点
    public void add(Node node) {
        if (node == null) {
            return;
        }

        // 判断传入结点的值，和当前子树的根结点的值的关系
        if (node.value < this.value) {
            // 如果当前结点的左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归的向左子树添加
                this.left.add(node);
            }
        } else {// 添加的结点的值大于当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归的向右子树添加结点
                this.right.add(node);
            }
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


}