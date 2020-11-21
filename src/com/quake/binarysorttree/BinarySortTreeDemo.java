package com.quake.binarysorttree;

/**
 * @author AKA二夕
 * @create 2020-10-31 23:13
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加节点到二叉排序树
        for (int value : arr) {
            binarySortTree.add(new Node(value));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树：");
        binarySortTree.infixOrder();

        //测试删除节点
        binarySortTree.delNode(7);
        System.out.println("删除节点后：");
        binarySortTree.infixOrder();
    }
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

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历~~~");
        }
    }

    // 查找需要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // 查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 编写方法：
     * 1、返回的是以node为根结点的二叉排序树的最小结点的值
     * 2、删除node为根结点的二叉排序树的最小结点
     *
     * @param node 传入的结点（当做二叉排序树的根结点）
     * @return 返回的 以node为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        // 循环的查找左子结点，就会找到最小的值
        while (target.left != null) {
            target = target.left;
        }
        // 这时target就指向了最小结点
        // 删除最小结点
        delNode(target.value);
        return target.value;
    }

    // 删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 1、需要先找到要删除的节点 targetNode
            Node targetNode = search(value);
            // 如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            // 2、如果当前这颗二叉排序树只一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //3 、去找到targetNode的父节点
            Node parent = searchParent(value);
            // 4、如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断targetNode是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {//是左子节点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {//是右子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除的是有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {// 删除只有一颗子树的节点
                // 如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {
                        // 如果targetNode是parent的左子节点
                        if (parent.left.value == targetNode.value) {
                            parent.left = targetNode.left;
                        } else {//targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {// 如果需要删除的节点有右子节点
                    if (parent != null) {
                        // 如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {// 如果targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
}

// 创建Node结点
class Node {
    int value;
    Node left;
    Node right;

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