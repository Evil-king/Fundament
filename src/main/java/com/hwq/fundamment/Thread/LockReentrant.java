package com.hwq.fundamment.Thread;

/**
 * @author hwq
 * @date 2019/04/13
 * <p>
 *     锁重入
 *     当一个线程得到一个对象锁后，再次请求此对象锁时是可以再次得到该对象的锁。这也证明在一个Synchronized方法/块的内部调用本类的
 *     其他Synchronized方法/块时候，是永远可以得到锁的。
 * </p>
 */
public class LockReentrant {

    public synchronized void a(){
        System.out.println("a");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b(){
        System.out.println("b");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LockReentrant lockReentrant2 = new LockReentrant();
        LockReentrant lockReentrant1 = new LockReentrant();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lockReentrant1.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockReentrant2.b();
            }
        }).start();
    }
}
