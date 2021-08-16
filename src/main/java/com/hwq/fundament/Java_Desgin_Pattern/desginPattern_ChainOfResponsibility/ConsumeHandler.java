package com.hwq.fundament.Java_Desgin_Pattern.desginPattern_ChainOfResponsibility;

/**
 * @author hwq
 * @date 2018/10/18
 */
public abstract class ConsumeHandler {

    private ConsumeHandler nextHandler;

    public ConsumeHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(ConsumeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * user申请人 free报销费用
     */
    public abstract void doHandler(String user, double free);
}
