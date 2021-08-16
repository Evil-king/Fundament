package com.hwq.fundament.JavaDataStructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2021/8/16 0016 19:58
 * @Description:
 */
public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//表示边的数目
    public static void main(String[] args) {
        int n = 5;
        String Vertex[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        //循环添加结点
        for (String vertex : Vertex){
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdges(0,1,1);//A-B
        graph.insertEdges(0,2,1);//A-C
        graph.insertEdges(1,2,1);//B-C
        graph.insertEdges(1,3,1);//B-D
        graph.insertEdges(1,4,1);//B-E

        graph.showGraph();

    }
    //构造器
    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }
    //图中常用的方法
    //返回结点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i(下标)对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回V1和V2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //打印图
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }
    //插入结点
    public void insertVertex(String str){
        vertexList.add(str);
    }
    /**
     * 添加边
     * @param v1 表示点的下标既是第几个顶点 A-B A->0 B->1
     * @param v2 第二个顶点对应的下标
     * @param weight 权重
     */
    public void insertEdges(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight; //这里反过来是因为这个矩阵是没有方向的
        numOfEdges++;
    }
}
