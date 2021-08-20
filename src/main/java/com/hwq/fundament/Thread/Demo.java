package com.hwq.fundament.Thread;

/**
 * @author hwq
 * @date 2019/04/14
 * <p>
 * 实现线程a执行完线程b执行，线程b执行完线程c执行 这样一个效果
 * 这里需要注意一下的是  a、b、c方法中的判断一定要用while不然会出现假唤醒的问题
 * </p>
 */
class ShareThreadSynchronized {
    private int signal;

    public synchronized void a() {
        while (signal != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal++;
        notifyAll();
    }

    public synchronized void b() {
        while (signal != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal++;
        notifyAll();
    }

    public synchronized void c() {
        while (signal != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        notifyAll();
    }
}

public class Demo {
    public static void main(String[] args) {
        ShareThreadSynchronized shareThreadSynchronized = new ShareThreadSynchronized();
        new Thread(() -> {
            for (int i = 0; i <=2; i++) {
                shareThreadSynchronized.b();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i <=2; i++) {
                shareThreadSynchronized.c();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i <=2; i++) {
                shareThreadSynchronized.a();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
    }
}
