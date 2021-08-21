package com.hwq.fundament.Thread.CreateThreadMethod;

/**
 * @author hwq
 * @date 2019/03/30
 * <p>
 * 创建线程方式四：匿名内部类
 * </p>
 */
public class CreateThread4 {

    public static void main(String[] args) {
        //继承Thread类
//        new Thread(){
//            @Override
//            public void run() {
//                System.out.println("继承Thread类的线程开始了.......");
//            }
//        }.start();

        //实现Runnable接口
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("实现Runnable接口的线程开始了.......");
//            }
//        }).start();

        //两者混合用
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现Runnable接口的线程开始了.......");
            }
        }) {
            @Override
            public void run() {
                System.out.println("继承Thread类的线程开始了.......");
            }
        }.start();
    }
}
