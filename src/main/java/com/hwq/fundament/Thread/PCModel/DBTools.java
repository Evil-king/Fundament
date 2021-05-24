package com.hwq.fundament.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:44
 * @Description:数据库交叉备份工具类
 */
public class DBTools {
    volatile private boolean flag = false;

    synchronized public void backupA() {
        try {
            while (flag == true) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(" ❤❤❤❤❤❤ ");
            }
            flag = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB(){
        try {
            while (flag == false) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(" 🔴🔴🔴🔴🔴🔴 ");
            }
            flag = false;
            notifyAll();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
