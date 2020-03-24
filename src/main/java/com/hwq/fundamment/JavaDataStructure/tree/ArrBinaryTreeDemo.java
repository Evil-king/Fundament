package com.hwq.fundamment.JavaDataStructure.tree;

/**
 * @Auther: Administrator
 * @Date: 2020/3/13 0013 15:05
 * @Description:顺序存储二叉树 特点：
 * 1、顺序二叉树通常只考虑完全二叉树
 * 2、第n个元素的左子结点为2*n+1
 * 3、第n个元素的右子结点为2*n+2
 * 4、第n个元素的父结点为（n-1）/2
 * 5、n表示二叉树中的第几个元素(按0开始编号)
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //创建一个ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
        System.out.println();
        arrBinaryTree.infixOrder();
        System.out.println();
        arrBinaryTree.postOrder();
    }
}

//编写一个ArrBineryTree 实现顺序二叉树遍历
class ArrBinaryTree {
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void infixOrder(){
        this.infixOrder(0);
    }

    public void postOrder(){
        this.preOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照顺序二叉树前序遍历");
        }
        //输出root结点元素
        System.out.print(arr[index]);
        //向左递归遍历
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //编写一个方法，完成顺序存储二叉树的中序遍历
    /**
     * @param index 数组的下标
     */
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照顺序二叉树前序遍历");
        }
        //向左递归遍历
        if ((2 * index + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }
        //输出root结点元素
        System.out.print(arr[index]);
        //向右递归遍历
        if ((2 * index + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    /**
     * @param index 数组的下标
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照顺序二叉树前序遍历");
        }
        //向左递归遍历
        if ((2 * index + 1) < arr.length) {
            postOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((2 * index + 2) < arr.length) {
            postOrder(2 * index + 2);
        }
        //输出root结点元素
        System.out.print(arr[index]);
    }
}

