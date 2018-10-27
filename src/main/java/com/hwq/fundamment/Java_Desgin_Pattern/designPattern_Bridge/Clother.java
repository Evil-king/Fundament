package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;


/**
 * @author hwq
 * @date 2018/10/02
 */
public class Clother extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的衣服是这样的.....");
    }

    @Override
    public void beSelled() {
        System.out.println("卖出去的衣服是这样的.....");
    }
}
