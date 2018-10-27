package com.hwq.fundamment.Java_Desgin_Pattern.designPatten_FactoryMethod;


public class NvWa {
    public static void main(String[] args) {
//        System.out.println("-----------------造出的第一批人是这样的：白种人");
//        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.classAdapter);
//        whiteHuman.cry();
//        whiteHuman.laugh();
//        whiteHuman.talk();
//        System.out.println("-----------------造出的第二批人是这样的：黄种人");
//        Human yellowHuman = HumanFactory.createHuman(YellowHuman.classAdapter);
//        yellowHuman.talk();
//        yellowHuman.laugh();
//        yellowHuman.cry();
//        System.out.println("-----------------造出的第三批人是这样的：黑种人");
//        Human blackHuman = HumanFactory.createHuman(BlackHuman.classAdapter);
//        blackHuman.talk();
//        blackHuman.laugh();
//        blackHuman.cry();

        //女娲烦躁了，爱是啥人种就是啥人种，烧把
        for(int i=0;i<100;i++){
            System.out.println("-------------随机产生人种了-------------");
            Human human = HumanFactory.createHuman();
            human.cry();
            human.laugh();
            human.talk();
        }
    }
}
