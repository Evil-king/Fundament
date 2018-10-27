package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;


/**
 * @author hwq
 * @date 2018/10/02
 * 房地产公司
 */
public class HouserCrop extends Corp {

    public HouserCrop(Product product) {
        super(product);
    }

    public void makeMoney(){
        super.makeMoney();
        System.out.println("房地产公司太赚钱了...");
    }
}
