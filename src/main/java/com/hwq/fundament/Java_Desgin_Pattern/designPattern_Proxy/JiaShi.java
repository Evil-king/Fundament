package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Proxy;

/**
 * 另外一个女的 贾氏
 */
public class JiaShi implements KindWomen {
    @Override
    public void makeEyesWithMen() {
        System.out.println("贾氏抛媚眼");
    }

    @Override
    public void happyWithMan() {
        System.out.println("贾氏和男人做那个......");
    }
}
