package com.hwq.fundament.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 14:03
 * @Description:
 * 方法join()的作用是使所属的线程对象X正常执行run()方法中的任务
 * 而使当前线程z进行无限期的阻塞，等待线程x销毁后再继续执行线程z后面的代码
 * 方法join()具有使线程排队运行的作用，有些类似同步的运行效果；
 * join与synchronized的区别是：
 * join在内部使用wait()方法进行等待，而synchronized关键字使用的是"对象监视器"原理做为同步
 */
public class JoinThread extends Thread{
    @Override
    public void run() {
        try {
            int secondValue = (int)(Math.random() * 1000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
