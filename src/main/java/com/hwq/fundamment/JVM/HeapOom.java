package com.hwq.fundamment.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/3/13 0013 19:24
 * @Description:
 */
public class HeapOom {
    byte[] b = new byte[1024*100];
    public static void main(String[] args) throws InterruptedException {
        List<HeapOom> all = new ArrayList<>();
        while (true){
            all.add(new HeapOom());
            Thread.sleep(10);
        }
    }
}
