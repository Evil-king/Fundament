package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Adapter.mkw.objectAdapter;

/**
 * @author hwq
 * @date 2018/09/23
 */
public class Adapter extends Usber implements Ps2 {

    private Usb usb;

    public Adapter(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void isPs2() {
        usb.isUsb();
    }

}
