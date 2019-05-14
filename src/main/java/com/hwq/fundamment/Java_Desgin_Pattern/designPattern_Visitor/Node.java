package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Visitor;

/**
 * @author hwq
 * @date 2018/10/18
 * <p>
 * 抽象结点类
 * </p>
 */
public abstract class Node {

    /**
     * 接受操作
     */
    public abstract void accept(Visitor visitor);
}
