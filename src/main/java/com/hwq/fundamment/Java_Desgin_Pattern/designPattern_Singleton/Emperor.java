package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * 懒汉模式 在用的时候再new对象
 */
public class Emperor {

    private static Emperor emperor = null;

    private Emperor() {
    }

    public static Emperor getInstance() {
        if (emperor == null) {
            emperor = new Emperor();
        }
        return emperor;
    }

    public static void emperorName() {
        System.out.println("我就是XXXX");
    }
}
