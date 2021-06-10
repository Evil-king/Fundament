package com.hwq.fundament.JavaDataStructure.tree;

/**
 * @Auther: Administrator
 * @Date: 2020/3/9 0009 22:29
 * @Description:二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建二叉树，后面我们学习以递归的方式创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setRight(node5);
//        node3.setLeft(node5);
        node3.setRight(node4);

        //前序遍历
//        System.out.println("前序遍历");
//        binaryTree.preOrder();

        //中序遍历
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();

        //后序遍历
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

        //前序遍历查找 需要查找四次
//        System.out.println("前序遍历方式~~~");
//        HeroNode heroNode = binaryTree.preOrderSearch(10);
//        if(heroNode != null){
//            System.out.printf("no=%d name=%s",heroNode.getNo(),heroNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄",10);
//        }

        //中序遍历查找 需要查找三次
//        System.out.println("中序遍历方式~~~");
//        HeroNode heroNode = binaryTree.infixOrderSearch(5);
//        if(heroNode != null){
//            System.out.printf("no=%d name=%s",heroNode.getNo(),heroNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄",5);
//        }


        //后序遍历查找 需要查找两次
//        System.out.println("后序遍历方式~~~");
//        HeroNode heroNode = binaryTree.postOrderSearch(5);
//        if(heroNode != null){
//            System.out.printf("no=%d name=%s",heroNode.getNo(),heroNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄",5);
//        }
        System.out.println("删除前，前序列遍历");
        binaryTree.preOrder();
        binaryTree.delNode1(2);
        System.out.println("删除后，前序列遍历");
        binaryTree.preOrder();
    }
}

//定义一个BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }

    //删除结点
    public void delNode1(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode1(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }

}


//节点
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
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历的方法
    public void preOrder() {
        System.out.println(this);//先输出父结点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历的方法
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历的方法
    public void postOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父结点
        System.out.println(this);
    }

    //前序遍历查找

    /**
     * @param no 查找no
     * @return 如果找到则返回该Node, 如果没有找到则返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        //比较当前结点
        if (this.no == no) {
            return this;
        }
        //1、判断当前结点的左子结点是否为空，如果不为空，则左递归前序查找
        //2、如果左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) { //说明我们找到左子树
            return resNode;
        }
        //左递归前序查找，找到结点，则返回，否则继续判断
        //当前结点的右子结点是否为空，如果不为空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序遍历");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序遍历");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    //递归删除结点
    //1、如果删除的节点是叶子节点，则删除该节点
    //2、如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no) {
        //思路
        //1、因为我们的二叉树是单向的，所以我们判断当前结点的子结点是否是需要删除的结点，而不能去判断当前这个结点是不是需要判断删除的结点
        //2、如果当前结点的左子节点不为空，并且左子节点就是要删除结点，就将this.left=null;并且就返回(结束递归删除)
        //3、如果当前结点的右子结点不为空，并且右子结点就是要删除的结点，就将this.right=null;并且就返回(结束递归删除)
        //4、如果第2和第3步没有删除结点，那么我们需要向左子树进行递归删除
        //5、如果第4步没有删除结点，则应当向右子树进行递归删除
        if (this.left != null && this.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.no == no) {
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


    public void delNode1(int no) {
        if (this.left != null && this.right != null && this.no == no) {
            this.setNo(this.left.getNo());
            this.setName(this.left.getName());
            this.left = null;
            return;
        }

        if (this.right != null && this.left == null && this.no == no) {
           this.setNo(this.right.getNo());
           this.setName(this.right.getName());
           this.right = null;
            return;
        }

        if (this.right == null && this.left != null && this.no == no) {
            this.setNo(this.left.getNo());
            this.setName(this.left.getName());
            this.left = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode1(no);
        }
        if (this.right != null) {
            this.right.delNode1(no);
        }
    }
}
