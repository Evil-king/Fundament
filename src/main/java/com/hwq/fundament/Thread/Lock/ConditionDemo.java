package com.hwq.fundament.Thread.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hwq
 * @date 2019/04/14
 * <p>
 * 针对Demo的改进 弃用wait/notify 该用condition
 * </p>
 */

class ShareResource {
    private int flag = 1;

    Lock lock = new ReentrantLock();

    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                a.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread() + ":: " + i + ":轮数:" + loop);
            }
            flag = 2;
            b.signal(); //通知B
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                b.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread() + ":: " + i + ":轮数:" + loop);
            }
            flag = 3;
            c.signal();//通知C
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread() + ":: " + i + ":轮数:" + loop);
            }
            flag = 1;
            a.signal();//通知A
        } finally {
            lock.unlock();
        }
    }
}

public class ConditionDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

    }
}
