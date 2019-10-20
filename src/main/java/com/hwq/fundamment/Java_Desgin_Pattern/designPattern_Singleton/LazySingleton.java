package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * @author hwq
 * @date 2019/10/20
 * 懒汉氏单利模式
 */
public class LazySingleton {

    public static LazySingleton lazySingleton = null;

    private LazySingleton(){

    }

    public synchronized static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
