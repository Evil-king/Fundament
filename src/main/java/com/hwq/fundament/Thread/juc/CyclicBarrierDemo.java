package com.hwq.fundament.Thread.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: Administrator
 * @Date: 2021/8/21 0021 12:22
 * @Description: CyclicBarrierDemo实现(集齐7颗龙珠召唤神龙)
 */
public class CyclicBarrierDemo {

    //创建固定值
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        //创建CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("*************集齐7颗龙珠召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 星龙被收集到");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
