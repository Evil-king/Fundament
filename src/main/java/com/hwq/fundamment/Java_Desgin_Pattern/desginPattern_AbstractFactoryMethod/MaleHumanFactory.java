package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;

/**
 * 男性工厂
 */
public class MaleHumanFactory extends AbstractHumanFactory {

    //创建一个男性黄种人
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YellowMaleHuman);
    }

    //创建一个男性白种人
    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHman);
    }

    //创建一个男性黑种人
    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }
}
