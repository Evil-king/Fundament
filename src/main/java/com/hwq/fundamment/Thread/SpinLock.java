package com.hwq.fundamment.Thread;

import java.util.Random;

/**
 * @author hwq
 * @date 2019/04/13
 * <p>
 * 自旋锁
 * 当多个线程执行完毕之后，打印一句话，结束
 * </p>
 */
public class SpinLock {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程开始执行了。。。。。");
                try {
                    Thread.sleep(new Random().nextInt(20000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了。。。。。");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程开始执行了。。。。。");
                try {
                    Thread.sleep(new Random().nextInt(20000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了。。。。。");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程开始执行了。。。。。");
                try {
                    Thread.sleep(new Random().nextInt(20000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了。。。。。");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程开始执行了。。。。。");
                try {
                    Thread.sleep(new Random().nextInt(20000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了。。。。。");
            }
        }).start();

        while (Thread.activeCount() != 1){
            //自旋
        }
        System.out.println("所有线程执行完毕了");
    }
}
