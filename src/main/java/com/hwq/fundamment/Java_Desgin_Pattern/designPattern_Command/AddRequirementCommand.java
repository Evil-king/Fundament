package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;


/**
 * @author hwq
 * @date 2018/10/07
 */
public class AddRequirementCommand extends Command {

    //执行增加一项需求增加的命令
    public void exceute() {
        //找到需求组
        super.requirementGrop.find();
        //要求增加一个需求
        super.requirementGrop.add();
        //要求增加一个页面
        super.pageGrop.add();
        //要求增加一个功能
        super.codeGrop.add();
        //给出计划
        super.requirementGrop.plan();
    }

    //撤回发错的命令
    public void undo() {
        System.out.println("撤回新增一项需求的命令.....");
    }
}
