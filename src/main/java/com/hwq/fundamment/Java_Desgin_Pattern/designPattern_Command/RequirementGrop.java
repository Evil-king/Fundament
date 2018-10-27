package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;


/**
 * @author hwq
 * @date 2018/10/07
 */
public class RequirementGrop extends Group {
    @Override
    public void add() {
        System.out.println("客户要求增加一项需求....");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项需求....");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一项需求....");
    }

    @Override
    public void find() {
        System.out.println("找到需求组....");
    }

    @Override
    public void plan() {
        System.out.println("客户要求需求变更计划....");
    }
}
