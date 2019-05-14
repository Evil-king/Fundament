package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;


/**
 * @author hwq
 * @date 2018/10/02
 * 定义一个公司的抽象类
 */
public abstract class Corp {

    private Product product;

    public Corp(Product product) {
        this.product = product;
    }


    public void makeMoney() {
        this.product.beProducted();
        this.product.beSelled();
    }
}
