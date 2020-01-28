package com.hwq.fundamment.Thread.Pool;

import com.hwq.fundamment.Thread.SubThread;

import java.util.concurrent.*;

public class ExecutorsDemo {
    private static ExecutorService executor = Executors.newFixedThreadPool(15);


//    private static ExecutorService executor = new ThreadPoolExecutor(5, 10,
//            60L, TimeUnit.SECONDS,
//            new ArrayBlockingQueue(50));


    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(executor.isShutdown()){
                executor.execute(new SubThread());
            }
        }
        try {
            System.out.println("11111111111111111");
            executor.shutdown();
            System.out.println("222222222222222222");
            if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String msgCustomerNo ="1,2,3";
//        String str[] = msgCustomerNo.split(",");
//        List<String> stringList= Arrays.asList(str);
//        for(String str1 : stringList){
//            System.out.println(str1);
//        }
    }
}
