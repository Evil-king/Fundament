package com.hwq.fundament.Thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hwq
 * @date 2019/04/14
 */
//先入先出队列
public class MyQueue<E> {
    private Object[] obj;//数组（队列）
    private int addIndex;//添加角标
    private int removeIndex;//移除脚标
    private int queueSize;//队列长度
    private Lock lock = new ReentrantLock();
    Condition addCondition = lock.newCondition();
    Condition removeCondition = lock.newCondition();

    //在构造器里设置队列长度
    public MyQueue(int count) {
        obj = new Object[count];
    }

    //添加
    public void add(E e) {
        lock.lock();//加锁
        while (queueSize == obj.length) {//假如队列长度等于数组长度，说明队列已满
            try {
                System.out.println("队列已满：" + Arrays.toString(obj));
                addCondition.await();//添加线程等待
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        obj[addIndex] = e;//将元素e添加进数据
        if (++addIndex == obj.length) {//如果添加脚标加1等于数组的长度，将添加脚标设置为0
            addIndex = 0;
        }
        queueSize++;//队列长度加1
        removeCondition.signal();//唤醒移除线程
        System.out.println("新增：" + Arrays.toString(obj));
        lock.unlock();//释放锁
    }

    //移除
    public void remove() {
        lock.lock();//加锁
        while (queueSize == 0) {//如果队列为0，表示队列空的
            try {
                System.out.println("队列为空：" + Arrays.toString(obj));
                removeCondition.await();//移除线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        obj[removeIndex] = null;//将第removeIndex元素设置为null

        if (++removeIndex == obj.length) {//如果removeIndex加1等于数组长度，将removeIndex设置为0
            removeIndex = 0;
        }
        queueSize--;//队列长度减1
        addCondition.signal();//唤醒添加线程
        System.out.println("删除：" + Arrays.toString(obj));
        lock.unlock();//释放锁
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue(4);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    q.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    q.remove();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

