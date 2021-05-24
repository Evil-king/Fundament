package com.hwq.fundament.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:24
 * @Description:启动类
 */
public class Run {
    //    public static void main(String[] args) throws InterruptedException {
////        String lock = "";
////        P p = new P(lock);
////        C c = new C(lock);
////        ThreadP[] pThread = new ThreadP[2];
////        ThreadC[] cThread = new ThreadC[2];
////        for (int i = 0; i < 2; i++) {
////            pThread[i] = new ThreadP(p);
////            pThread[i].setName("生产者 " + (i + 1));
////            cThread[i] = new ThreadC(c);
////            cThread[i].setName(" 消费者 " + (i + 1));
////            pThread[i].start();
////            cThread[i].start();
////            Thread.sleep(5000);
////            Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
////            Thread.currentThread().getThreadGroup().enumerate(threadArray);
////            for (int j = 0; j < threadArray.length; j++) {
////                System.out.println(threadArray[j].getName() + " " +threadArray[j].getState());
////            }
////        }
////    }
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }
}
