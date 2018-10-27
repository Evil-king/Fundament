package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Visitor;

/**
 * @author hwq
 * @date 2018/10/18
 * <p>
 *     具体节点类NodeA
 * </p>
 */
public class NodeA extends Node {

    /**
     * 接受操作
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeA特有的方法
     */
    public String operationA(){
        return "NodeA";
    }
}
