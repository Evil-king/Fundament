package com.hwq.fundament.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 14:06
 * @Description:
 */
public class JoinTest {

    public static void main(String[] args) {
        try {
            JoinThread joinThread = new JoinThread();
            joinThread.start();
            joinThread.join();
            System.out.println("我想当JoinThread线程对象执行完毕后我在执行,我做到了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
