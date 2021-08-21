package com.hwq.fundament.Thread.juc;


import java.util.concurrent.CountDownLatch;

/**
 * @Auther: Administrator
 * @Date: 2021/8/21 0021 12:14
 * @Description: 演示CountDownLatch 减少计数
 */
public class CountDownLatchDemo {
    //6个同学陆续离开教室之后，班长锁门
    public static void main(String[] args) throws Exception {
        //创建CountDownLatch对象 设置初始值
        CountDownLatch countDownLatch = new CountDownLatch(6);
        //6个同学陆续离开教室之后
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
                //计数器 -1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        //等待
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 班长锁门走人了");
    }
}
