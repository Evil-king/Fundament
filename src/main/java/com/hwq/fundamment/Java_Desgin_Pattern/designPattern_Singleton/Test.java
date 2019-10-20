package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * @author hwq
 * @date 2019/10/20
 */
public class Test {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new T());
        Thread thread2 = new Thread(new T());

        thread1.start();
        thread2.start();

        System.out.println("project is end");
    }
}
