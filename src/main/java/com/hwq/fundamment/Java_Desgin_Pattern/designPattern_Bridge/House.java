package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;


/**
 * @author hwq
 * @date 2018/10/02
 */
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的房子是这个样的.....");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了.......");
    }
}
