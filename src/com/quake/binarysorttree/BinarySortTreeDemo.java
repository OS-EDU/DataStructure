package com.quake.binarysorttree;

/**
 * @author AKA二夕
 * @create 2020-10-31 23:13
 */
public class BinarySortTreeDemo {
}

class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    // 添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;// 如果root为空，则直接让root指向node
        } else {
            root.add(node);
        }
    }
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

    /**
     * 查找需要删除的结点
     *
     * @param value 需要删除的结点的值
     * @return 如果找到就返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {// 找到，就是当前结点
            return this;
        } else if (value < this.value) {// 如果查找的值小于当前结点的值，向左子树递归查找
            // 如果左子树为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {// 如果查找的值不小于当前结点的值，向右子树递归查找
            // 如果右子树为空
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value 需要查找结点的值
     * @return 返回的是需要删除结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        // 如果当前结点就是需要删除的结点的父结点，直接返回即可
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果要查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;// 没有找到父结点
            }
        }
    }
}