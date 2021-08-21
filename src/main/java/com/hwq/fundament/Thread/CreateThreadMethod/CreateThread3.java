package com.hwq.fundament.Thread.CreateThreadMethod;

import java.util.concurrent.FutureTask;

/**
 * @author hwq
 * @date 2019/03/30
 * <p>
 * 创建线程方式三：实现Callable接口 并且有返回值和能抛出异常 结合FutureTask一起用
 * </p>
 */
public class CreateThread3{

    //第一种方式：lamb表达式方式
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<>(() ->{
            System.out.println("luck come in Callable");
            return 100;
        });

        FutureTask<Integer> task1 = new FutureTask<>(() ->{
            System.out.println("mary come in Callable");
            return 1024;
        });

        new Thread(task,"lucy").start();
        new Thread(task1,"mary").start();

//        while (!task.isDone()){
//            System.out.println("wait.....");
//        }

        Integer result = task.get();
        Integer result1 = task1.get();
        System.out.println(result);
        System.out.println(result1);
    }

    //第二种方式
//    public static void main(String[] args) throws Exception {
//        FutureTask<Integer> task = new FutureTask<>(new CreateThread3());
//
//        new Thread(task).start();
//
//        Integer result = task.get();
//        System.out.println("最终结果为：" + result);
//    }
//
//
//    @Override
//    public Integer call() throws Exception {
//        System.out.println("进行紧张的计算.....");
//        Thread.sleep(3000);
//        return 1;
//    }
}
