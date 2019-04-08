package com.hwq.fundamment.test.FactoryMethod;

/**
 * @author hwq
 * @date 2019/04/05
 */
public class BananaFactory implements FruitFactory{
    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}
