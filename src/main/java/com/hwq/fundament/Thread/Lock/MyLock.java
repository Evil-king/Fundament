package com.hwq.fundament.Thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author hwq
 * @date 2019/04/07
 * <p>
 * 手写实现可重入锁,这里只是实现lock,unlock方法
 * </p>
 */
public class MyLock implements Lock {

    private boolean isLocked = false;

    Thread lockBy = null;

    private int lockCount = 0;

    @Override
    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        //第一个进来的线程不让它等待
        while (isLocked && currentThread != lockBy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isLocked = true;
            lockBy = currentThread;
            lockCount++;
        }
    }

    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()) {
            lockCount--;

            if (lockCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
