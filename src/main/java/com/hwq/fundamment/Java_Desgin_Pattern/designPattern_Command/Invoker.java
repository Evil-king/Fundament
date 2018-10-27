package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;


/**
 * @author hwq
 * @date 2018/10/07
 */
public class Invoker {

    //什么命令
    private Command command;

    //客户发出什么命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //执行客户的命令
    public void action(){
        this.command.exceute();
    }
}
