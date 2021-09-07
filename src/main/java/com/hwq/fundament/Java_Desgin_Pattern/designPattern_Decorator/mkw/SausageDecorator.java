package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Decorator.mkw;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 17:46
 * @Description:
 */
public class SausageDecorator extends AbstractDecorator{

    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一根油条";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
