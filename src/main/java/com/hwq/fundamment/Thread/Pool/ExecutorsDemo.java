package com.hwq.fundamment.Thread.Pool;

import com.hwq.fundamment.Thread.SubThread;

import java.util.concurrent.*;

public class ExecutorsDemo {
    private static ExecutorService executor = Executors.newFixedThreadPool(15);


//    private static ExecutorService executor = new ThreadPoolExecutor(5, 10,
//            60L, TimeUnit.SECONDS,
//            new ArrayBlockingQueue(50));


    public static void main(String[] args) {
        executor.execute(()->{
            System.out.println("胡文卿");
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("胡文卿最牛B");
            }
        });
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            if(executor.isShutdown()){
//                executor.execute(new SubThread());
//            }
//        }
//        try {
//            System.out.println("11111111111111111");
//            executor.shutdown();
//            System.out.println("222222222222222222");
//            if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
//                executor.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String msgCustomerNo ="1,2,3";
//        String str[] = msgCustomerNo.split(",");
//        List<String> stringList= Arrays.asList(str);
//        for(String str1 : stringList){
//            System.out.println(str1);
//        }
    }

    /**
     *      if (workerCountOf(c) < corePoolSize) {  如果小于核心数
     *             if (addWorker(command, true))  放到核心线程里面执行
     *                 return;
     *             c = ctl.get();
     *         }
     *         if (isRunning(c) && workQueue.offer(command)) { 如果大于核心线程 放入到队列中
     *             int recheck = ctl.get();
     *             if (! isRunning(recheck) && remove(command))
     *                 reject(command);  拒绝策略
     *             else if (workerCountOf(recheck) == 0)
     *                 addWorker(null, false);   加入任务
     *         }
     *         else if (!addWorker(command, false))
     *             reject(command);  拒绝策略
     *
     *
     *
     *      execute----->创建Work对象--->addWorker---启动Work对象---runWorker---获取任务---->getTask
     *      ---->启动自行任务----->processWorkerExit(这里之后又会再次调用addWorker方法)
     *
     *
     *
     */
}
