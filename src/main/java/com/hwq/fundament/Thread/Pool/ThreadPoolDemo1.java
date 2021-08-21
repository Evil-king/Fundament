package com.hwq.fundament.Thread.Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Administrator
 * @Date: 2021/8/21 0021 17:10
 * @Description: 演示线程池三种常用分类
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        //一池五线程
//        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);//5个窗口

        //一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();//1个窗口

        //一池可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();//根据需求自己创建线程

        //10个顾客请求
        try {
            for (int i = 1; i <= 10 ; i++) {
                //执行
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool3.shutdown();
        }
    }
}
