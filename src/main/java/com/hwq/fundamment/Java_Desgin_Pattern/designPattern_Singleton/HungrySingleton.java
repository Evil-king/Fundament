package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * @author hwq
 * @date 2019/10/20
 * 饿汉氏单利模式
 */
public class HungrySingleton {

    private HungrySingleton(){}

    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    public HungrySingleton getInsence(){
        return hungrySingleton;
    }
}
