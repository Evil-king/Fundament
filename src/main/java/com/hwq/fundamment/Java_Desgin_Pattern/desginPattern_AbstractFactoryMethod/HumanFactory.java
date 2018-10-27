package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;


public interface HumanFactory {

    //制造黄色人种
    public Human createYellowHuman();

    //制造白色人种
    public Human createWhiteHuman();

    //制造黑色人种
    public Human createBlackHuman();
}
