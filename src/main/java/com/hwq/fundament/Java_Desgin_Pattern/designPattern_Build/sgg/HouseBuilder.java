package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.sgg;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 13:03
 * @Description: 抽象的建造者
 */
public abstract class HouseBuilder {

    protected House house = new House();

    //将建造的流程写好，抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造房子，将产品返回
    public House buildHouse(){
        return house;
    }
}
