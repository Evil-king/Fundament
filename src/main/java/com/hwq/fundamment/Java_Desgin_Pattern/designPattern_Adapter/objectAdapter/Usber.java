package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Adapter.objectAdapter;

/**
 * @author hwq
 * @date 2018/09/23
 */
public class Usber implements Usb {
    @Override
    public void isUsb() {
        System.out.println("USB口");
    }
}
