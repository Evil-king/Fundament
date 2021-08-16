package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * @author hwq
 * @date 2019/10/20
 */
public class T implements Runnable{
    @Override
    public void run() {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        LazyDoubleCheckSingleton lazyDoubleCheckSingleton = LazyDoubleCheckSingleton.getInstance();
        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"  "+ staticInnerClassSingleton);
    }
}
