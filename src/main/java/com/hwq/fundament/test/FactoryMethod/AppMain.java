package com.hwq.fundament.test.FactoryMethod;

/**
 * @author hwq
 * @date 2019/04/05
 */
public class AppMain {

    public static void main(String[] args) {
        Fruit apple = new AppleFactory().getFruit();

        Fruit banana = new BananaFactory().getFruit();

        apple.get();
        banana.get();

    }
}
