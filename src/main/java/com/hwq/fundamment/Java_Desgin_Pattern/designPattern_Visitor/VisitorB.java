package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Visitor;

/**
 * @author hwq
 * @date 2018/10/18
 * <p>
 *     具体访问者VisitorB类
 * </p>
 */
public class VisitorB implements Visitor {

    /**
     * 对应于NodeA的访问操作
     */
    @Override
    public void visit(NodeA node) {
        System.out.println(node.operationA());
    }
    /**
     * 对应于NodeB的访问操作
     */
    @Override
    public void visit(NodeB node) {
        System.out.println(node.operationB());
    }

}
