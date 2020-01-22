package com.hwq.fundamment.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:52
 * @Description:
 */
public class BackupB extends Thread{

    private DBTools dbTools;

    public BackupB(DBTools dbTools){
        super.run();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
