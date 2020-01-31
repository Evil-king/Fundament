package com.hwq.fundamment.Thread.PCModel;

/**
 * @author hwq
 * @date 2019/04/13
 * <p>
 * 商品
 * wait/notify实现的生产和消费者
 * </p>
 */
public class MallDemo {

    private int count;

    private static final int MAX_COUNT = 10;

    public synchronized void push() {
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + "生产者库存达到上限，停止生产");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "生产者生产,当前库存为：" + count);
        notifyAll();
    }

    public synchronized void customer() {
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存为零，消费者等待....");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "消费者消费,当前库存为：" + count);
        notifyAll();
    }


}
