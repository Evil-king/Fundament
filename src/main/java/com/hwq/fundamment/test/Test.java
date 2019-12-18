package com.hwq.fundamment.test;

/**
 * @author hwq
 * @date 2019/12/07
 * <p>
 * int a=10;中的a在被调用之前就已经创建并初始化，在调用func方法时，他被当做参数传入，所以这个a是实参。
 * 而func(int a)中的a只有在func被调用时它的生命周期才开始，而在func调用结束之后，它也随之被JVM释放掉，，所以这个a是形参
 */
public class Test {
//    public static void fun(int a) {
//        a = 20;
//        System.out.println(a);
//    }

    public static void valueCrossTest(int age, float weight) {
        System.out.println("传入的age:" + age);
        System.out.println("传入的weight:" + weight);

        age = 33;
        weight = 89.5f;

        System.out.println("方法内重新赋值后的age:" + age);
        System.out.println("方法内重新赋值后的weight:" + weight);

    }

    public static void PersonCrossTest(Person person){
        System.out.println("传入的person的name："+person.getName());
        person.setName("我是张小龙");
        System.out.println("方法内重新赋值后的name："+person.getName());
    }


    public static void main(String[] args) {
//        int a = 10;
//        fun(a);
//        System.out.println("方法执行完后的a:" + a);
        int a = 23;
        float w = 78.9f;
        valueCrossTest(a,w);
        System.out.println("方法执行后的age："+a);
        System.out.println("方法执行后的weight："+w);
        System.out.println("-----------------------------");
        Person p=new Person();
        p.setName("我是马化腾");
        p.setAge("45");
        PersonCrossTest(p);
        System.out.println("方法执行后的name："+p.getName());
    }
}
