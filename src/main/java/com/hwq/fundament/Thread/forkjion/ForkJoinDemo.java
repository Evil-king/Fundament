package com.hwq.fundament.Thread.forkjion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Auther: Administrator
 * @Date: 2021/8/21 0021 19:25
 * @Description: 分支合并框架Demo
 */

class MyTask extends RecursiveTask<Integer> {

    //拆分差值不能超过10，计算10以内运算
    private static final Integer VALUE = 10;
    private int begin;
    private int end;
    private int result;

    //创建一个有参的构造
    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    //拆分和合并的过程
    @Override
    protected Integer compute() {
        if ((end - begin) <= VALUE) {
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else { //进一步进行拆分
            //获取中间值
            int middle = (begin + end) / 2;
            //拆分左边
            MyTask task01 = new MyTask(begin, middle);
            //拆分右边
            MyTask task02 = new MyTask(middle + 1, end);
            task01.fork();
            task02.fork();

            //合并结果
            result = task01.join() + task02.join();
        }
        return result;
    }

}

public class ForkJoinDemo {
    public static void main(String[] args) throws Exception{
        //创建MyTask对象
        MyTask myTask = new MyTask(1,100);
        //创建分支合并池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        //获取最终合并之后结果
        Integer result = forkJoinTask.get();
        System.out.println(result);
        //最后关闭池对象
        forkJoinPool.shutdown();
    }
}
