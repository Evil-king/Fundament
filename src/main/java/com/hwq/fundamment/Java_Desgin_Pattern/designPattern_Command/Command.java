package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;


/**
 * @author hwq
 * @date 2018/10/07
 */
public abstract class Command {
    //先定义好三个需求组
    RequirementGrop requirementGrop = new RequirementGrop();

    PageGrop pageGrop = new PageGrop();

    CodeGrop codeGrop = new CodeGrop();

    //命令执行方法
    public abstract void exceute();

    //撤回命令
    public abstract void undo();
}
