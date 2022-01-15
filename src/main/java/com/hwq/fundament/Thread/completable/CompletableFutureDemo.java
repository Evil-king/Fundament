package com.hwq.fundament.Thread.completable;

import java.util.concurrent.CompletableFuture;

/**
 * @Auther: Administrator
 * @Date: 2021/8/21 0021 19:41
 * @Description: 异步调用和同步调用
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception{
        //同步调用
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+" : completableFuture1");
        });
        completableFuture1.get();

        //异步调用
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+" : completableFuture2");
            //模拟异常
            // int i = 10/0;
            return 1024;
        });
        completableFuture2.whenComplete((t,u)->{
            System.out.println("----------t="+t);
            System.out.println("----------u="+u);//异常信息
        }).get();

    }
}
