package com.hwq.fundament.Thread;

/**
 * @author hwq
 * @date 2019/04/14
 * <p>
 * 实现线程a执行完线程b执行，线程b执行完线程c执行 这样一个效果
 * </p>
 */
public class Demo {

    private int signal;

    public synchronized void a() {
        while (signal != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal++;
        notifyAll();
    }

    ;

    public synchronized void b() {
        while (signal != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal++;
        notifyAll();
    }

    ;

    public synchronized void c() {
        while (signal != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        notifyAll();
    }

    ;

    static class A implements Runnable {
        private Demo demo;

        public A(Demo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                demo.b();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class B implements Runnable {

        private Demo demo;

        public B(Demo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                demo.c();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class C implements Runnable {

        private Demo demo;

        public C(Demo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                demo.a();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo d = new Demo();

        A a = new A(d);
        B b = new B(d);
        C c = new C(d);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }
}
