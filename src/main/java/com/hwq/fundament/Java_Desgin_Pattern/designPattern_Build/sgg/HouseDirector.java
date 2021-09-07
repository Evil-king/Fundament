package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.sgg;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 13:11
 * @Description:
 */
public class HouseDirector {

    HouseBuilder houseBuilder = null;

    //构造器传入houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //setter方法传入houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }

}
