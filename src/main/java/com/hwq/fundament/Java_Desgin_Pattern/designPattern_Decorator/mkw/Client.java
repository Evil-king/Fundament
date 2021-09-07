package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Decorator.mkw;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 17:46
 * @Description: 使用场景：想吃煎饼 但是又想加鸡蛋又想加油条
 */
public class Client {
    public static void main(String[] args) {
        ABattercake aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);
        System.out.println(aBattercake.getDesc()+" 销售价格"+aBattercake.cost());
    }
}
