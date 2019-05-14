package com.hwq.fundamment.Thread;

/**
 * @author hwq
 * @date 2019/04/07
 */
public class MyLock2Test {

    private int value;

    MyLock2 lock = new MyLock2();

    public int getNext() {
        lock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

    // 测试可重入
    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();

    }

    public void b() {
        lock.lock();
        System.out.println("b");
        c();
        lock.unlock();
    }

    public void c() {
        lock.lock();
        System.out.println("c");
        lock.unlock();
    }


    public static void main(String[] args) {
        MyLock2Test test = new MyLock2Test();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.a();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println(Thread.currentThread().getId() + "" + test.getNext());
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println(Thread.currentThread().getId() + "" + test.getNext());
//                }
//            }
//        }).start();
    }
}
