package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Strategy;

/**
 * 策略一
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国佬帮忙，让吴国太给孙权施加压力");
    }
}
