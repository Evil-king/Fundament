package com.hwq.fundamment.Thread;

/**
 * @author hwq
 * @date 2019/04/13
 * <p>
 *     生产者
 *     wait/notify实现的生产和消费者
 * </p>
 */
public class Push implements Runnable{

    private MallDemo mallDemo;

    public Push(MallDemo mallDemo) {
        this.mallDemo = mallDemo;
    }

    @Override
    public void run() {
        while (true){
            mallDemo.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
