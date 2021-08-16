package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Proxy;

/**
 * 定义实现一种女人类型的 潘金莲
 */
public class PanJinLian implements KindWomen {
    @Override
    public void makeEyesWithMen() {
        System.out.println("潘金莲抛媚眼");
    }

    @Override
    public void happyWithMan() {
        System.out.println("潘金莲在和男人做那个。。。。");
    }
}
