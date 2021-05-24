package com.hwq.fundament.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:21
 * @Description:
 */
public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p){
        super();
        this.p = p;
    }
    @Override
    public void run() {
        super.run();
        while (true){
            p.setValue();
        }
    }

}
