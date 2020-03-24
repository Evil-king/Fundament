package com.hwq.fundamment.JavaDataStructure.tree;

/**
 * 顺序存储二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历：");
        arrBinaryTree.preOrder();
        System.out.println("中序遍历：");
        arrBinaryTree.infixOrder();
        System.out.println("后序遍历：");
        arrBinaryTree.postOrder();
    }
}

//编写一个ArrBinaryTree，实现顺序存储二叉树便利
class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载
    public void preOrder(){
        this.preOrder(0);
    }
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //编写一个方法，完成顺序存储二叉树的中序遍历
    public void infixOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }

        //输出当前元素
        System.out.println(arr[index]);

        if (2 * index + 2 < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    //编写一个方法，完成顺序存储二叉树的后序遍历
    public void postOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }
        //输出当前元素
        System.out.println(arr[index]);
    }
}
