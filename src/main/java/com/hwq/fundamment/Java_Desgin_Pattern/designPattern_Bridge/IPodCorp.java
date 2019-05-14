package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;

/**
 * @author hwq
 * @date 2018/10/02
 */
public class IPodCorp extends Corp {

    public IPodCorp(Product product) {
        super(product);
    }

    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱啊....");
    }
}
