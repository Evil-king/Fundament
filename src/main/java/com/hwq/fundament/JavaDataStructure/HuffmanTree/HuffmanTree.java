package com.hwq.fundament.JavaDataStructure.HuffmanTree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node rootNode = createHuffmanTree(arr);

        //Test
        perOrder(rootNode);
    }

    //编写一个前序遍历的方法
    public static void perOrder(Node root){
        if(root != null){
            root.preOrder();
        } else {
            System.out.println("是空树，无法遍历");
        }
    }

    //创建HuffmanTree的方法
    public static Node createHuffmanTree(int[] arr) {
        //第一步为了操作方便
        //1、遍历arr 数组
        //2、将arr 的每个元素构建成一个Node
        //3、将Node 放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        //我们处理的过程是循环的过程
        while (nodes.size() > 1) {
            //排序 从小到大
            Collections.sort(nodes);

            System.out.println("nodes=" + nodes);

            //取出根节点权值最小的两颗二叉树
            //1、取出权值最小的结点(二叉树)
            Node leftNode = nodes.get(0);
            //2、取出第二小的结点(二叉树)
            Node rightNode = nodes.get(1);
            //3、构建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //4、从ArrayList删除已经用过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5、将parentNode加入到Nodes
            nodes.add(parent);
        }
        //返回HuffmanTree的root的结点
        return nodes.get(0);
    }
}

//创建结点类
//为了让Node对象 支持排序Collections集合排序
//让Node 实现Comparable接口
class Node implements Comparable<Node> {
    int value;//结点权值
    Node left;//指向右子结点
    Node right;//指向左子结点

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
