package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;

/**
 * @author hwq
 * @date 2018/10/07
 */
public class Client {
    public static void main(String[] args) {

        Invoker fox = new Invoker();

        //首先找到需求组说过来谈需求，并且修改
        System.out.println("------------客户要求增加一个需求------------");
        Command addRequirementCommand = new AddRequirementCommand();


        System.out.println("------------客户要求删除一个页面------------");
        Command deletePageCommand = new DeletePageCommand();

        //收到命令
        fox.setCommand(addRequirementCommand);

        fox.setCommand(deletePageCommand);

        //执行命令
        fox.action();

        //执行撤回命令
        addRequirementCommand.undo();

        deletePageCommand.undo();
    }
}
