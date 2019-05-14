package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Build;


/**
 * @author hwq
 * @date 2018/10/02
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Human human = director.createHumanByDirecotr(new SmartManBuilder());
        System.out.println(human.getHead());
        System.out.println(human.getBody());
        System.out.println(human.getHand());
        System.out.println(human.getFoot());
    }
}
