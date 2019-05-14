package com.hwq.fundamment.Think_In_Java.innerClass.TestExtendClassCover;

/**
 * @author hwq
 * @date 2018/10/23
 * <p>
 * 覆盖内部类
 * </p>
 */
public class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}
