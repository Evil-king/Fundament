package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.sgg;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 13:14
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        //普通房子
        CommonHouse commonHouse = new CommonHouse();
        //高楼
        HighBuilder highBuilder = new HighBuilder();

        HouseDirector houseDirector = new HouseDirector(commonHouse);
        houseDirector.constructHouse();
        System.out.println();
        houseDirector.setHouseBuilder(highBuilder);
        houseDirector.constructHouse();

    }
}
