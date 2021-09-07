package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.sgg;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 13:06
 * @Description:
 */
public class HighBuilder extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基15米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("高楼玻璃屋顶");
    }
}
