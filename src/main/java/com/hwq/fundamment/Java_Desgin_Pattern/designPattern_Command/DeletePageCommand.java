package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;


/**
 * @author hwq
 * @date 2018/10/07
 */
public class DeletePageCommand extends Command {

    //执行删除一个页面的命令
    public void exceute() {
        super.pageGrop.find();

        super.pageGrop.delete();

        super.pageGrop.plan();
    }

    @Override
    public void undo() {
        System.out.println("撤回删除页面的命令....");
    }
}
