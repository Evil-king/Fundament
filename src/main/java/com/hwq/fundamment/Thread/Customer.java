package com.hwq.fundamment.Thread;

/**
 * @author hwq
 * @date 2019/04/13
 * <p>
 * 消费者
 * wait/notify实现的生产和消费者
 * </p>
 */
public class Customer implements Runnable {

    private MallDemo mallDemo;

    public Customer(MallDemo mallDemo) {
        this.mallDemo = mallDemo;
    }

    @Override
    public void run() {
        while (true) {
            mallDemo.customer();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
