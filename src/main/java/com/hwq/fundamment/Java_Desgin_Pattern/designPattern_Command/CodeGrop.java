package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;


/**
 * @author hwq
 * @date 2018/10/07
 */
public class CodeGrop extends Group {
    @Override
    public void add() {
        System.out.println("客户要求增加一项功能....");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项功能....");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一项功能....");
    }

    @Override
    public void find() {
        System.out.println("找到代码组....");
    }

    @Override
    public void plan() {
        System.out.println("客户要求功能变更计划....");
    }
}
