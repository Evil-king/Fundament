package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Decorator;


/**
 * @author hwq
 * @date 2018/10/08
 */
public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportDecorator(){
        System.out.println("我的排名是25名....");
    }

    public void report(){
        this.reportDecorator();
        super.report();
    }
}
