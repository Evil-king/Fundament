package com.hwq.fundament.Thread.PCModel;

/**
 * @Auther: Administrator
 * @Date: 2020/1/22 0022 13:52
 * @Description:
 */
public class BackupA extends Thread{

    private DBTools dbTools;

    public BackupA(DBTools dbTools){
        super.run();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}
