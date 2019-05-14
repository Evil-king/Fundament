package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;


public class main {

    public static void main(String[] args) {
        //男性生产线
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        //女性生产线
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();

        //生产线完成 开始生产人
        Human maleyellowHuman = maleHumanFactory.createYellowHuman();

        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();

        maleyellowHuman.cry();
        maleyellowHuman.laugh();
        maleyellowHuman.sex();
        femaleYellowHuman.sex();

        /**
         * 后面可以继续......
         */

    }
}
