package com.hwq.fundamment.Thread;

/**
 * @author hwq
 * @date 2019/04/13
 * <p>
 * wait\notify
 * </p>
 */
public class WaitNotifyDemo {

    private volatile int value = 0;

    public void set(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    public static void main(String[] args) {
        WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (waitNotifyDemo) {
                    System.out.println("开始执行。。。。。。");
                    waitNotifyDemo.set(1);
                    System.out.println("设置值完毕。。。。。");
                    waitNotifyDemo.notify();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (waitNotifyDemo) {
                    while (waitNotifyDemo.get() != 1) {
                        try {
                            waitNotifyDemo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("模拟代码的执行。。。。。");
                }
            }
        }).start();
    }
}
