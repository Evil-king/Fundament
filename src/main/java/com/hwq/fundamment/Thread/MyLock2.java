package com.hwq.fundamment.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author hwq
 * @date 2019/04/07
 * <p>
 *     使用AQS重写自己的锁
 * </p>
 */
public class MyLock2 implements Lock {

    private Helper helper = new Helper();


    private class Helper extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            // 如果第一个线程进来，可以拿到锁，因此我们返回true

            // 如果其他线程进来，拿不到锁，则返回false,有种特例，如果当前进来的线程和当前保存的线程是同一个线程，则可以拿到锁，但有代价，要更新状态值

            // 如何判断是第一个线程进来还是其他线程进来呢？jdk文档中的这句话
            //此类的设计目标是成为依靠单个原子 int 值来表示状态的大多数同步器的一个有用基础
            //只是为了获得同步而只追踪使用 getState()、setState(int) 和 compareAndSetState(int, int) 方法来操作以原子方式更新的 int 值。
            int state = getState();

            Thread t = Thread.currentThread();

            if(state == 0){
                if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(t);
                    return true;
                }
            }
            else if(getExclusiveOwnerThread() == t){
                setState(state + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前线程
//            if(Thread.currentThread() != getExclusiveOwnerThread()){
//                throw new RuntimeException();
//            }
            int state = getState() - arg;

            boolean flag = false;

            if(state == 0){
                setExclusiveOwnerThread(null);//设置当前线程
                flag = true;
            }
            setState(state);//把当前状态设置为0
            return flag;
        }


        Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.tryAcquire(1);
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
        return helper.tryAcquireSharedNanos(1,unit.toNanos(time));
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
