package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Observer;


/**
 * @author hwq
 * @date 2018/10/17
 * <p>
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * </p>
 */
public interface Observerable {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}
