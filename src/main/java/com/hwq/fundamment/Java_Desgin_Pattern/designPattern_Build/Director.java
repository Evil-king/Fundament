package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Build;
/**
 * @author hwq
 * @date 2018/10/02
 */
public class Director {
    public Human createHumanByDirecotr(IBuildHuman bh){
        bh.buildBody();
        bh.buildFoot();
        bh.buildHand();
        bh.buildHead();
        return bh.createHuman();
    }
}

