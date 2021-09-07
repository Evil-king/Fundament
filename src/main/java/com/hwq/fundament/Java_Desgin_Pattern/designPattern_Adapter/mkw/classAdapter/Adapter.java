package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Adapter.mkw.classAdapter;

/**
 * @author hwq
 * @date 2018/09/23
 */
public class Adapter extends Usber implements Ps2 {
    @Override
    public void isPs2() {
        isUsb();
    }

}
