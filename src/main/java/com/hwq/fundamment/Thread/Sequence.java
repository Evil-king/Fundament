package com.hwq.fundamment.Thread;

/**
 * @author hwq
 * @date 2019/04/07
 */
public class Sequence {

    private MyLock lock = new MyLock();

    private int value;


    //测试可重入锁
    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        new Thread(new Runnable() {
            @Override
            public void run() {
                s.a();
            }
        }).start();
    }
}
