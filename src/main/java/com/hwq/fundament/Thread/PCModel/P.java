package com.hwq.fundament.Thread.PCModel;

import com.hwq.fundament.Thread.PCModel.Entity.ValueObject;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:10
 * @Description: 生产者
 */
public class P {
     private String lock;
     public P(String lock){
         super();
         this.lock = lock;
     }

     public void setValue() {
         try {
             synchronized (lock) {
                 if (!ValueObject.value.equals("")) {
                     System.out.println("生产者 "+Thread.currentThread().getName() + "WAITING了❤ ");
                     lock.wait();
                 }
                 System.out.printf("生产者 " +Thread.currentThread().getName() + " RUNNABLE了 ");
                 String value = System.currentTimeMillis() + "_" + System.nanoTime();
                 ValueObject.value = value;
                 lock.notifyAll();
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
}
