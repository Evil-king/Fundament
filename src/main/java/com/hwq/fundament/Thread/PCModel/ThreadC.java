package com.hwq.fundament.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:21
 * @Description:
 */
public class ThreadC extends Thread{
    private C c;

    public ThreadC(C c){
        super();
        this.c = c;
    }
    @Override
    public void run() {
        super.run();
        while (true){
            c.getValue();
        }
    }

}
