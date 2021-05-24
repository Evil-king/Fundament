package com.hwq.fundament.test.FactoryMethod;

/**
 * @author hwq
 * @date 2019/04/05
 */
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
