//: generics/coffee/Coffee.java
package com.hwq.fundamment.Think_In_Java.Genericity;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
} ///:~
