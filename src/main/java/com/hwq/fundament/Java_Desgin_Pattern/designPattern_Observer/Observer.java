package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Observer;

/**
 * @author hwq
 * @date 2018/10/17
 * <p>
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 * </p>
 */
public interface Observer {

    public void update(String message);
}
