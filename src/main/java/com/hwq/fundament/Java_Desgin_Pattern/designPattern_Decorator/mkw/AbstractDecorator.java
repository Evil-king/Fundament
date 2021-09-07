package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Decorator.mkw;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 17:43
 * @Description: 抽象的装饰者
 */
public class AbstractDecorator extends ABattercake{

    private ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    @Override
    public String getDesc() {
        return aBattercake.getDesc();
    }

    @Override
    public int cost() {
        return aBattercake.cost();
    }
}
