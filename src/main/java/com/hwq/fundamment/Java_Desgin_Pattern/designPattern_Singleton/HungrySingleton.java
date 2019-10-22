package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Singleton;

import java.io.Serializable;

/**
 * @author hwq
 * @date 2019/10/20
 * 饿汉氏单利模式
 */
public class HungrySingleton implements Serializable {

    private HungrySingleton(){}

    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInsence(){
        return hungrySingleton;
    }
}
