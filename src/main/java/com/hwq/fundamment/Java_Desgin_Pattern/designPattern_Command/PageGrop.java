package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Command;


/**
 * @author hwq
 * @date 2018/10/07
 */
public class PageGrop extends Group {
    @Override
    public void add() {
        System.out.println("客户要求增加一项页面....");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项页面....");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一项页面....");
    }

    @Override
    public void find() {
        System.out.println("找到美工组....");
    }

    @Override
    public void plan() {
        System.out.println("客户要求页面变更计划....");
    }
}
