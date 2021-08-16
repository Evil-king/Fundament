package com.hwq.fundament.Thread;

public class SubThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
