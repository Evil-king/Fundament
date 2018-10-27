package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Strategy;

/**
 * 策略中心
 */
public class Context {
    //构造函数
    private IStrategy iStrategy;

    private TStrategy tStrategy;

    public Context(IStrategy iStrategy){
        this.iStrategy =iStrategy;
    }
    public Context(TStrategy tStrategy){
        this.tStrategy =tStrategy;
    }

    public void operate(){
        this.iStrategy.operate();
    }

    public void run(){
        this.tStrategy.run();
    }
}
