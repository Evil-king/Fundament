package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Decorator.mkw;

/**
 * @Auther: Administrator
 * @Date: 2021/9/7 0007 17:41
 * @Description: 具体的煎饼类
 */
public class Battercake extends ABattercake{
    @Override
    public String getDesc() {
        return "煎饼好吃又香";
    }

    @Override
    public int cost() {
        return 1;
    }
}
