package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Visitor;

/**
 * @author hwq
 * @date 2018/10/18
 */
public interface Visitor {

    /**
     * 对应于NodeA的访问操作
     */
    public void visit(NodeA node);

    /**
     * 对应于NodeB的访问操作
     */
    public void visit(NodeB node);
}
