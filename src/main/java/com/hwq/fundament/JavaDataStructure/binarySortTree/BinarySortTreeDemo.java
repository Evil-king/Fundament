package com.hwq.fundament.JavaDataStructure.binarySortTree;

public class BinarySortTreeDemo {
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if(node == null){
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value){
            //如果当前结点左子结点为null
            if (this.left == null){
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else { //添加的结点的值大于 当前结点的值
            if (this.right == null){
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }

        }
    }

    //中序遍历
    public void infixOrder(){

    }
}