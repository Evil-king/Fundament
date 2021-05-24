package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Strategy;

/**
 * 策略二
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行！");
    }
}
