package com.hwq.fundament.JavaDataStructure.queue;

import java.util.Scanner;

/**
 * @Auther: Administrator
 * @Date: 2020/2/22 0022 15:48
 * @Description: 用数组实现的队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 推出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出队列");
            System.out.println("h(head): 查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据是%d\n",res);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }
}

//使用数组模拟队列编写一个ArrayQueue类
class   ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//指向对列头的指针
    private int rear;//指向队列尾的指针
    private int arr[];//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize  = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;//指向对列头的指针,front是指向队列头的前一个位置
        rear = -1;//指向队列尾的指针，rear是指向队列尾的后一个位置
    }

    //判断队列是否已经满了
    public  boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
       return front == rear;
    }

    //添加数据到队列
    public void addQueue(int value){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满了，不能加数据了~");
            return;
        }
        rear++;//因为是后进先出所以指向队尾的指针往上加
        arr[rear] = value;
    }

    //获取队列数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据了~");
        }
        front++;//front让下加
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列为空，没有数据~");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据了~");
        }
        return arr[front+1];
    }

}
