package com.hwq.fundament.Think_In_Java.innerClass.TestExtendClassCover;

/**
 * @author hwq
 * @date 2018/10/23
 */
public class BiggEgg extends Egg {

    public class Yolk {
        public Yolk() {
            System.out.println("BiggEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BiggEgg();
    }
}
