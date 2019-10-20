package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Singleton;

/**
 * @author hwq
 * @date 2019/10/20
 * 延迟初始化，降低创建类的开销
 */
public class LazyDoubleCheckSingleton {
    public volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public synchronized static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1、内存分配给这个对象
                    //2、初始化对象
                    //3、设置lazyDoubleCheckSingleton 指向刚分配的内存对象
                    //在2和3的时候可能会出现指令重排序问题
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
