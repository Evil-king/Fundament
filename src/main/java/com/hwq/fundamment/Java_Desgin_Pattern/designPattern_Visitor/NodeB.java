package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Visitor;

/**
 * @author hwq
 * @date 2018/10/18
 * <p>
 *     具体结点B
 * </p>
 */
public class NodeB extends Node {

    /**
     * 接受方法
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeB特有的方法
     */
    public String operationB(){
        return "NodeB";
    }
}
