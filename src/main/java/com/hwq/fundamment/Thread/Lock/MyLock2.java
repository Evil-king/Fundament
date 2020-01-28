package com.hwq.fundamment.Thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author hwq
 * @date 2019/04/07
 * <p>
 * 使用AQS重写自己的锁
 * </p>
 */
public class MyLock2 implements Lock {

    private Helper helper = new Helper();


    private class Helper extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            /**
             * 如果第一个线程进来，可以拿到锁，因此我们可以返回true
             * 如果第二个线程进来，拿不到锁，返回false，
             * 有种特例，如果当前进来的线程和占用排它锁的线程是同一个线程(重入)，则允许可以拿到锁，但是要更新状态值
             * */
            Thread t = Thread.currentThread();
            //如何判断是第一个线程进来还是其他线程进来
            int state = getState();//拿到状态
            if (state == 0) {//如果状态等于0 ，无状态（初始状态）
                if (compareAndSetState(0, arg)) {// 如果状态等于0 ，将状态设置为arg
                    setExclusiveOwnerThread(t);//设置占用排它锁的线程是当前线程
                    return true;
                }
            } else if (getExclusiveOwnerThread() == t) {// 重入
                setState(state + 1);//更新状态值
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前线程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }
            int state = getState() - arg;

            boolean flag = false;

            if (state == 0) {
                setExclusiveOwnerThread(null);//设置当前线程
                flag = true;
            }
            setState(state);//把当前状态设置为0
            return flag;
        }


        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }
}
