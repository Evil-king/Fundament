package com.hwq.fundamment.Thread;

import java.util.concurrent.CountDownLatch;

public class DoneThread extends Thread{
    private CountDownLatch cdl;

    public DoneThread(String name, CountDownLatch cdl)
    {
        super(name);
        this.cdl = cdl;
    }

    public void run()
    {
        try
        {
            System.out.println(this.getName() + "要等待了, 时间为" + System.currentTimeMillis());
            cdl.await();
            System.out.println(this.getName() + "等待完了, 时间为" + System.currentTimeMillis());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
