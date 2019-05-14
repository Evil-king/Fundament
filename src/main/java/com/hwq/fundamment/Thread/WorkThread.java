package com.hwq.fundamment.Thread;

import java.util.concurrent.CountDownLatch;

public class WorkThread extends Thread {
    private CountDownLatch cdl;
    private int sleepSecond;

    public WorkThread(String name, CountDownLatch cdl, int sleepSecond) {
        super(name);
        this.cdl = cdl;
        this.sleepSecond = sleepSecond;
    }

    public void run() {
        try {
            System.out.println(this.getName() + "启动了，时间为" + System.currentTimeMillis());
            Thread.sleep(sleepSecond * 1000);
            cdl.countDown();
            System.out.println(this.getName() + "执行完了，时间为" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
