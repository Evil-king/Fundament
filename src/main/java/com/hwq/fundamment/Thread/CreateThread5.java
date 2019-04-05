package com.hwq.fundamment.Thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author hwq
 * @date 2019/03/30
 * <p>
 *     创建线程方式五：定时器Timer
 * </p>
 */
public class CreateThread5 {


    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer线程开始执行了.......");
            }
        },0,100);
    }
}
