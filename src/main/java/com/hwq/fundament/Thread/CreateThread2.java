package com.hwq.fundament.Thread;

/**
 * @author hwq
 * @date 2019/03/30
 * <p>
 * 创建线程方式二：实现Runnable接口
 * </p>
 */
public class CreateThread2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("线程开始了.....");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new CreateThread2());
        Thread t2 = new Thread(new CreateThread2());

        t1.start();
        t2.start();
    }
}
