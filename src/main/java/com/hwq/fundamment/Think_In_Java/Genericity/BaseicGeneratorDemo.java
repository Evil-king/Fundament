package com.hwq.fundamment.Think_In_Java.Genericity;

/**
 * @author hwq
 * @date 2018/10/26
 */
public class BaseicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
