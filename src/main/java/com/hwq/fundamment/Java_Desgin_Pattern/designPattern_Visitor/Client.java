package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Visitor;

/**
 * @author hwq
 * @date 2018/10/18
 */
public class Client {

    public static void main(String[] args) {
        //创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //给结构增加一个节点
        os.add(new NodeA());
        //给结构增加一个节点
        os.add(new NodeB());
        //创建一个访问者
        Visitor visitor = new VisitorA();
        os.action(visitor);
    }
}
