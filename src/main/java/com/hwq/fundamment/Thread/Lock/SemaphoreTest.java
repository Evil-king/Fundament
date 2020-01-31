package com.hwq.fundamment.Thread.Lock;

import java.util.concurrent.Semaphore;

/**
 * Semaphore是非常有用的一个组件，它相当于是一个并发控制器，是用于管理信号量的。
 * 构造的时候传入可供管理的信号量的数值，这个数值就是控制并发数量的，我们需要控制并发的代码，
 * 执行前先通过acquire方法获取信号，执行后通过release归还信号 。每次acquire返回成功后，
 * Semaphore可用的信号量就会减少一个，如果没有可用的信号，acquire调用就会阻塞，等待有release调用释放信号后，acquire才会得到信号并返回。
 *
 * <p>
 * Semaphore分为单值和多值两种：
 * 1、单值的Semaphore管理的信号量只有1个，该信号量只能被1个，只能被一个线程所获得，意味着并发的代码只能被一个线程运行，这就相当于是一个互斥锁了
 * 2、多值的Semaphore管理的信号量多余1个，主要用于控制并发数
 * </P>
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获得了信号量,时间为" + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "释放了信号量,时间为" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++)
            threads[i] = new Thread(runnable);
        for (int i = 0; i < threads.length; i++)
            threads[i].start();
    }
}
