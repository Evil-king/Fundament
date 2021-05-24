package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Observer;


/**
 * @author hwq
 * @date 2018/10/17
 * <p>
 * 观察者
 * 实现了update方法
 * </p>
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
