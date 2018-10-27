package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;

/**
 * @author hwq
 * @date 2018/10/02
 */
public class IPod extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的iPod是这个样子......");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的iPod卖出去了......");
    }
}
