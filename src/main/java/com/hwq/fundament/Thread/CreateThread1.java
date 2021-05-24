package com.hwq.fundament.Thread;

/**
 * @author hwq
 * @date 2019/03/30
 * <p>
 * 创建线程方式一：继承Thread类
 * </p>
 */
public class CreateThread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("线程开始了....");
        }
    }

    public static void main(String[] args) {
        CreateThread1 t1 = new CreateThread1();
        CreateThread1 t2 = new CreateThread1();

        t1.start();
        t2.start();
    }
}
