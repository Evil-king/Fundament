package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * @author hwq
 * @date 2019/10/20
 * 饿汉氏((静态变量)
 */
public class HungrySingleton  {

    private HungrySingleton(){}

    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInsence(){
        return hungrySingleton;
    }
}
