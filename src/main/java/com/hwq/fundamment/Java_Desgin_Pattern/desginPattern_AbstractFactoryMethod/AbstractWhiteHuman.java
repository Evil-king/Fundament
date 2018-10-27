package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;

public abstract class AbstractWhiteHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("白种人会大笑，侵略的笑声");
    }

    @Override
    public void cry() {
        System.out.println("白种人会大哭");
    }

    @Override
    public void talk() {
        System.out.println("白种人会说话，一般都是单字节");
    }
}
