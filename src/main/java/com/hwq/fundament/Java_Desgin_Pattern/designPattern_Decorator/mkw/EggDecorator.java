package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Decorator.mkw;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 17:44
 * @Description: 具体的装饰者之一
 */
public class EggDecorator extends AbstractDecorator{

    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
