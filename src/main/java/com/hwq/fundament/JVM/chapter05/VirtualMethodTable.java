package com.hwq.fundament.JVM.chapter05;

/**
 * 虚方法表的举例
 *
 * @author shkstart
 * @create 2020 下午 1:11
 */
interface Friendly {
    void sayHello();
    void sayGoodbye();
}
class DogDemo {
    public void sayHello() {
    }
    public String toString() {
        return "Dog";
    }
}
class CatDemo implements Friendly {
    public void eat() {
    }
    public void sayHello() {
    }
    public void sayGoodbye() {
    }
    protected void finalize() {
    }
    public String toString(){
        return "Cat";
    }
}

class CockerSpaniel extends DogDemo implements Friendly {
    public void sayHello() {
        super.sayHello();
    }
    public void sayGoodbye() {
    }
}

public class VirtualMethodTable {
}
