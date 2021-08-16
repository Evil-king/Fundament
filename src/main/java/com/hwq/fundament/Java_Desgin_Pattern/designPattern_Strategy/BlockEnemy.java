package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Strategy;

/**
 * 策略三
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵!");
    }
}
