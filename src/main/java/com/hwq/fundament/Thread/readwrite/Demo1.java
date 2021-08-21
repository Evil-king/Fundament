package com.hwq.fundament.Thread.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: Administrator
 * @Date: 2021/8/21 0021 16:00
 * @Description: 演示读写锁降级
 */
public class Demo1 {
    public static void main(String[] args) {
        //可重入读写锁对象
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();//读锁
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();//写锁

//        //写锁降级读锁
//        //1、获取写锁
//        writeLock.lock();
//        System.out.println("huwnqing");
//
//        //2、获取读锁
//        readLock.lock();
//        System.out.println("---read");
//
//        //释放写锁
//        writeLock.unlock();
//        //释放读锁
//        readLock.unlock();

        //先读不能升级为写锁
        //2、获取读锁
        readLock.lock();
        System.out.println("---read");

        //1、获取写锁
        writeLock.lock();
        System.out.println("huwnqing");

        //释放写锁
        writeLock.unlock();
        //释放读锁
        readLock.unlock();

    }
}
