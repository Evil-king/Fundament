package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.sgg;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 13:05
 * @Description:
 */
public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子盖屋顶");
    }
}
