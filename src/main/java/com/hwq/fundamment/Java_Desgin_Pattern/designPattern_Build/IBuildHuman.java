package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Build;


/**
 * @author hwq
 * @date 2018/10/02
 */
public interface IBuildHuman {
    public void buildHead();
    public void buildBody();
    public void buildHand();
    public void buildFoot();
    public Human createHuman();
}
