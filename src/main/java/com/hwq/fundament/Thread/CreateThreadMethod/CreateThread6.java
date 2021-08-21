package com.hwq.fundament.Thread.CreateThreadMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hwq
 * @date 2019/03/30
 * <p>
 * 创建线程池的方式创建线程
 * </p>
 */
public class CreateThread6 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        threadPool.shutdown();
    }
}
