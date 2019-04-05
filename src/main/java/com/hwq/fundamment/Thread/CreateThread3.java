package com.hwq.fundamment.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author hwq
 * @date 2019/03/30
 * <p>
 *     创建线程方式三：实现Callable接口 并且有返回值和能抛出异常 结合FutureTask一起用
 * </p>
 */
public class CreateThread3 implements Callable<Integer> {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<>(new CreateThread3());

        Thread thread = new Thread(task);
        thread.start();

        Integer result = task.get();
        System.out.println("最终结果为：" + result);
    }


    @Override
    public Integer call() throws Exception {
        System.out.println("进行紧张的计算.....");
        Thread.sleep(3000);
        return 1;
    }
}
