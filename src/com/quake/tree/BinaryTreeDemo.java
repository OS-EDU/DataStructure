package com.quake.tree;

/**
 * @author AKA二夕
 * @create 2020-09-19 21:04
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();

        //创建需要的节点
        HeroNode root = new HeroNode(1, "A");
        HeroNode node2 = new HeroNode(2, "B");
        HeroNode node3 = new HeroNode(3, "C");
        HeroNode node4 = new HeroNode(4, "D");
        HeroNode node5 = new HeroNode(5, "E");
        HeroNode node6 = new HeroNode(6, "F");
        HeroNode node7 = new HeroNode(7, "G");
        HeroNode node8 = new HeroNode(8, "H");

        //手动创建该该二叉树
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node6);
        node2.setRight(node3);
        node3.setRight(node5);
        node3.setLeft(node4);
        node6.setRight(node7);
        node7.setLeft(node8);

        //测试 遍历
        System.out.println("前序遍历：");
        binaryTree.preOrder();
        System.out.println("中序遍历：");
        binaryTree.infixOrder();
        System.out.println("后序遍历：");
        binaryTree.postOrder();

        //测试 查找
        System.out.println("前序遍历查找：");
        HeroNode resNode = binaryTree.infixOrderSearch(4);
        if (resNode != null) {
            System.out.printf("找到该节点，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
        }
        System.out.println();
    }
}

// 定义BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;// 定义根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //递归删除节点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root节点，这里立即判断root是不是就是需要删除的节点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，无可删除节点~~~~");
        }
    }

}

// 先创建HeroNode结点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                ", name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    // 编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);// 先输出父结点
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        // 递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出父结点
        System.out.println(this);
        // 递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param no 查找no
     * @return 如果找到就返回该Node，如果没有找到返回null
     */
    public HeroNode preOrderSearch(int no) {
        // 比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        // 1、判断当前结点的左子结点是否为空，如果不为空，则递归前序查找
        // 2、如果做递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {// 说明左子树找到
            return resNode;
        }
        // 3、左递归前序查找，找到结点，则返回，否则继续判断
        // 4、当前结点的右子结点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        // 判断当前结点的左子结点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        // 如果找到，则返回，如果没有找到就和当前结点比较，如果是则返回当前结点
        if (this.no == no) {
            return this;
        }
        // 否则继续进行右递归的中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        // 判断当前结点的左子结点是否为空，如果不为空，则递归后序查找
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {// 说明左子树找到
            return resNode;
        }
        // 如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        // 如果左右子树都没有找到，就比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 递归删除节点
     * 说明：
     * 1、如果删除的节点是叶子节点，则删除该节点
     * 2、如果删除的节点是非叶子节点，则删除该树
     */
    public void delNode(int no) {
        //思路：
        /**
         * 1、因为该二叉树是单向的，所以是判断当前节点的子节点是否为需要删除的节点，而不能去判断当前这个节点是不是需要删除节点
         * 2、如果当前节点的左子节点不为空，并且左子节点就是需要删除的节点，就将this.left = null;并且就返回（结束递归删除）
         * 3、如果当前节点的右子节点不为空，并且右子节点就是需要删除的节点，就将this.right = null;并且就返回（结束递归删除）
         * 4、如果第2和第3步没有删除节点，那么就需要向左子树进行递归删除
         * 5、如果第4步也没有删除节点，则应当向右子树进行递归删除
         */
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}