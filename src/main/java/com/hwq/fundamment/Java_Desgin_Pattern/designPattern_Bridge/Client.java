package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;


/**
 * @author hwq
 * @date 2018/10/02
 */
public class Client {

    public static void main(String[] args) {
        HouserCrop houserCrop = new HouserCrop(new House());
//        houserCrop.prodcut();
//        houserCrop.sell();
        houserCrop.makeMoney();

        System.out.println("------------------------");

        ClotherCorp clotherCorp = new ClotherCorp(new Clother());
//        clotherCorp.prodcut();
//        clotherCorp.sell();
        clotherCorp.makeMoney();

        System.out.println("------------------------");


        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();
    }
}
