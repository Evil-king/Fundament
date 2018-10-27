package com.hwq.fundamment.Java8.Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author hwq
 * @date 2018/10/18
 * <p>
 *     1、只有一个抽象方法的函数式接口
 *     2、集合批量操作
 *     3、流操作
 * </p>
 */
public class Main {

    public static void main(String[] args) {
        //1、只有一个抽象方法的函数式接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        }).start();

        Runnable runnable = () -> System.out.println("t2");
        new Thread(runnable).start();

        new Thread(() -> System.out.println("t3")).start();

//        new Thread(() -> run("t4")).start();

        new Thread(() -> {String str = "t5";
            System.out.println(str);}).start();


        //2、集合批量操作
        List<String> list = Arrays.asList("a","b","c");
        for(String str  : list){
            System.out.println(str);
        }

        list.forEach((e) -> System.out.println(e));

        //3、流操作 下面是流查询list集合中等于"a"的数量
        int num = (int) list.stream().filter((e) ->"a".equals(e)).count();
        System.out.println(num);
    }

//    private static void run(String t4) {
//
//        System.out.println(t4);
//    }
}
