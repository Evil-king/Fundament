package com.hwq.fundamment.JavaDataStructure.stack;

import java.util.Scanner;

/**
 * @Auther: Administrator
 * @Date: 2020/2/27 0027 13:39
 * @Description: 数组模拟栈结构
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //先创建一个ArrayStack对象
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示从栈取出数据");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


class ArrayStack{
    private int maxSize; //栈的大小
    private int[] stack;//数组 数组模 拟栈，数据就放在该数组中
    private int top = -1;//top表示栈顶，初始化为-1
    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //栈空
    public  boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //先判断栈是否满了
        if(isFull()){
            System.out.println("栈已经满了");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈 将栈顶的数据返回 top--
    public int pop(){
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空，没有数据~~~");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈 遍历时需要从栈顶开始显示
    public void showStack(){
        if(isEmpty()){
            System.out.println("栈空，没有数据~~~");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
