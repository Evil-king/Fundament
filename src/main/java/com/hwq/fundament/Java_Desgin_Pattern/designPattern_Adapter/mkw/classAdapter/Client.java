package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Adapter.mkw.classAdapter;

/**
 * @author hwq
 * @date 2018/09/23
 */
public class Client {
    public static void main(String[] args) {
        Ps2 p = new Adapter();
        p.isPs2();
    }
}
