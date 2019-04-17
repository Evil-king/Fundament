package com.hwq.fundamment.Thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author hwq
 * @date 2019/04/17
 */
public class CountDownLatchDemo {
    private int[] nums;//存储每一行计算的结果


    public CountDownLatchDemo(int line) {
        nums = new int[line];
    }

    //求行和
    public void clce(String line, int index, CountDownLatch countDownLatch) {
        String nus[] = line.split(",");
        int total = 0;
        for (String num : nus) {
            total += Integer.parseInt(num);
        }
        nums[index] = total;//把每行的结果放入指定的数组中，和为数组的下标
        System.out.println(Thread.currentThread().getName() + " 执行计算任务... " + line + " 结果为：" + total);
        countDownLatch.countDown();//CountDownLatch计数器减1
    }

    //统计
    public void sum() {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println("最终的结果为：" + total);
    }

    //读取数据
    public static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/Macx/Desktop/num.txt"));
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contents;
    }

    public static void main(String[] args) {
        List<String> contents = readFile();//读取数据
        int lineCount = contents.size();//行数
        CountDownLatch countDownLatch = new CountDownLatch(lineCount);
        CountDownLatchDemo demo = new CountDownLatchDemo(lineCount);
        for (int i = 0; i < contents.size(); i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.clce(contents.get(j), j, countDownLatch);
                }
            }).start();
        }
//        while (Thread.activeCount() == 1) {
//
//        }
        try {
            countDownLatch.await();//等待所有线程将行求和全部进行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.sum();//汇总求和
    }

}
