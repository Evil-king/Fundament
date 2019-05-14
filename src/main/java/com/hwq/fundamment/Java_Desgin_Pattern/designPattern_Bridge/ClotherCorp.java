package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;


/**
 * @author hwq
 * @date 2018/10/02
 * 服装公司
 */
public class ClotherCorp extends Corp {

    public ClotherCorp(Clother clother) {
        super(clother);
    }

    public void makeMoney() {
        super.makeMoney();
        System.out.println("服装公司赚小钱...");
    }
}
