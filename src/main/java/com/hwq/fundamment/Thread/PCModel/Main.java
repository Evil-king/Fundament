package com.hwq.fundamment.Thread.PCModel;

/**
 * @author hwq
 * @date 2019/04/14
 * <p>
 * wait/notify实现的生产和消费者
 * </p>
 */
public class Main {

    public static void main(String[] args) {
        MallDemo mallDemo = new MallDemo();

        Push push = new Push(mallDemo);
        Customer customer = new Customer(mallDemo);

        new Thread(push).start();
        new Thread(push).start();
        new Thread(push).start();
        new Thread(push).start();
        new Thread(push).start();

        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
    }
}
