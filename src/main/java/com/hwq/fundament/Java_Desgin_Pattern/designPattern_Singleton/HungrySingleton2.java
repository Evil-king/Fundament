package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * @Auther: Administrator
 * @Date: 2021/8/28 0028 21:10
 * @Description: 饿汉氏(静态代码块)
 */
public class HungrySingleton2 {
    //1、构造器私有化，外部不能new
    private HungrySingleton2(){}

    //2、本类内部创建对象实例
    private static HungrySingleton2 hungrySingleton2;

    static {
        hungrySingleton2 = new HungrySingleton2();
    }

    public static HungrySingleton2 getInsence(){
        return hungrySingleton2;
    }
}
