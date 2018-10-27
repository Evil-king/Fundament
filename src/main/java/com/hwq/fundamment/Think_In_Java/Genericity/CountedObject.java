package com.hwq.fundamment.Think_In_Java.Genericity;

/**
 * @author hwq
 * @date 2018/10/26
 */
public class CountedObject {
    private static long count = 0;
    private final long id = count ++;
    public long id(){return id;}
    public String toString(){return "CountedObject：" + id;}
}
