package com.hwq.fundamment.Thread.PCModel;

import com.hwq.fundamment.Thread.PCModel.Entity.ValueObject;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:18
 * @Description: 消费者
 */
public class C {
    private String lock;

    public C(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    System.out.println("消费者 "+Thread.currentThread().getName() + "WAITING了💢 ");
                    lock.wait();
                }
                System.out.println("消费者 "+Thread.currentThread().getName() + "RUNNABLE了");
                ValueObject.value = "";
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
