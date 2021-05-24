package com.hwq.fundament.Java8.Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author hwq
 * @date 2018/10/18
 *
 * 1、举例  (o1, o2) -> Integer.compare(12, 29);
 * 2、格式
 *      ->：lambda操作符 或 箭头操作符
 *      ->左边：lambda形参列表(其实就是接口中的抽象方法的形参列表)
 *      ->右边：lambda体(其实就是重写的抽象方法的方法体)
 *
 * 3、Lambda表达式的使用:(分为6中情况)
 *   总结：
 *   ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 *   ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句(可能是return语句),可以省略这一对{}和return关键字
 *
 * 4、Lambda表达式的本质：作为函数式接口的实例
 *
 * 5、如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
 */
public class Main {
    //语法格式一：无参，无返回值
    @Test
    public void Test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111");
            }
        };

        r1.run();

        System.out.println("***************************");

        Runnable r2 =()-> System.out.println("11111111");
        r2.run();
    }

    //语法格式二：Lambda需要一个参数，但是没有返回值
    @Test
    public void Test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么?");

        System.out.println("*************************");

        Consumer<String> con1 = (String s)-> System.out.println(s);
        con1.accept("谎言和誓言的区别是什么?");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断出来，称为"类型推断"
    @Test
    public void Test3(){
        Consumer<String> con1 = (String s)-> System.out.println(s);
        con1.accept("谎言和誓言的区别是什么?");

        System.out.println("*************************");

        Consumer<String> con2 = (s)-> System.out.println(s);
        con2.accept("谎言和誓言的区别是什么?");
    }

    //语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void Test4(){
        Consumer<String> con1 = (s)-> System.out.println(s);
        con1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("*************************");

        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void Test5(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //....................
                return Integer.compare(o1,o2);
            }
        };
        comparator.compare(12,20);

        System.out.println("*************************");

        Comparator<Integer> comparator1 =(o1,o2) ->{
            //....................
            return Integer.compare(o1,o2);
        };
        comparator1.compare(1,20);
    }

    //语法格式六:当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void Test6(){
        Comparator<Integer> comparator1 =(o1,o2) ->{
            return Integer.compare(o1,o2);
        };
        comparator1.compare(1,20);

        System.out.println("*************************");

        Comparator<Integer> comparator2 =(o1,o2) ->Integer.compare(o1,o2);

        comparator2.compare(1,20);
    }
}
