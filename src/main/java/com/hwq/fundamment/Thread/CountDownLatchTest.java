package com.hwq.fundamment.Thread;

import java.util.concurrent.CountDownLatch;

/**
 *
 * CountDownLatch
 *
 * CountDownLatch主要提供的机制是当多个（具体数量等于初始化CountDownLatch时count参数的值）线程都达到了预期状态或完成预期工作时触发事件，
 * 其他线程可以等待这个事件来触发自己的后续工作。值得注意的是，CountDownLatch是可以唤醒多个等待的线程的。
 *
 * 到达自己预期状态的线程会调用CountDownLatch的countDown方法，等待的线程会调用CountDownLatch的await方法。如果CountDownLatch初始化的count值为1，那么这就退化为一个单一事件了，即是由一个线程来通知其他线程，效果等同于对象的wait和notifyAll，
 * count值大于1是常用的方式，目的是为了让多个线程到达各自的预期状态，变为一个事件进行通知，线程则继续自己的行为。
 *
 *
 * <p>
 *     效果十分明显，解释一下：
 *
 * 1、启动2个线程DoneThread线程等待3个WorkThread全部执行完
 *
 * 2、3个WorkThread全部执行完，最后执行完的WorkThread3执行了秒符合预期
 *
 * 3、后三句从时间上看几乎同时出现，说明CountDownLatch设置为3，WorkThread3执行完，两个wait的线程马上就执行后面的代码了
 *
 * 这相当于是一种进化版本的等待/通知机制，它可以的实现的是多个工作线程完成任务后通知多个等待线程开始工作，之前的都是一个工作线程完成任务通知一个等待线程或者一个工作线程完成任务通知所有等待线程。
 *
 * CountDownLatch其实是很有用的，特别适合这种将一个问题分割成N个部分的场景，所有子部分完成后，通知别的一个/几个线程开始工作。
 * 比如我要统计C、D、E、F盘的文件，可以开4个线程，分别统计C、D、E、F盘的文件，统计完成把文件信息汇总到另一个/几个线程中进行处理
 * </p>
 */
public class CountDownLatchTest{
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(3);
        DoneThread dt0 = new DoneThread("DoneThread1", cdl);
        DoneThread dt1 = new DoneThread("DoneThread2", cdl);
        dt0.start();
        dt1.start();
        WorkThread wt0 = new WorkThread("WorkThread1", cdl, 2);
        WorkThread wt1 = new WorkThread("WorkThread2", cdl, 3);
        WorkThread wt2 = new WorkThread("WorkThread3", cdl, 4);
        wt0.start();
        wt1.start();
        wt2.start();
    }
}
