package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Adapter.objectAdapter;

/**
 * @author hwq
 * @date 2018/09/23
 */
public class Client {
    public static void main(String[] args) {
        Ps2 p = new Adapter(new Usber());
        p.isPs2();
    }
}
