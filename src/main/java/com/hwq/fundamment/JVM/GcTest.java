package com.hwq.fundamment.JVM;

/**
 * @Auther: Administrator
 * @Date: 2020/2/4 0004 15:41
 * @Description: 判断对象是否要回收：1、引用计数法 2、可达性分析法
 *
 * -verbose:gc -XX:+PrintGCDetails
 */
public class GcTest {
    private Object instance;

    public GcTest(){
        Byte[] bytes = new Byte[20 * 1024 * 1024];
    }

    public static void main(String[] args) {
        GcTest t1 = new GcTest();
        GcTest t2 = new GcTest();

        t1.instance = t2;
        t2.instance = t1;

        t1 = null;
        t2 = null;

        System.gc();
    }
}
