package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Strategy;

/**
 * 实施类  实施策略的类
 */
public class ZhaoYun {

    public static void main(String[] args) {
        Context context;
        //执行第一个策略
        System.out.println("执行第一个策略");
        context = new Context(new BackDoor());
        context.operate();

        //执行第二个策略
        System.out.println("执行第二个策略");
        context = new Context(new GivenGreenLight());
        context.operate();

        //执行第三个策略
        System.out.println("执行第三个策略");
        context = new Context(new BlockEnemy());
        context.operate();

        //执行第四个策略
        System.out.println("执行第四个策略");
        context = new Context(new FourStrategy());
        context.run();
    }
}
