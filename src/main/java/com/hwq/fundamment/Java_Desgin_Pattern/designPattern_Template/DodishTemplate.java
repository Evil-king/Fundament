package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Template;

/**
 * @author hwq
 * @date 2018/09/23
 */
public abstract class DodishTemplate {
    /**
     * 具体的整个过程
     */
    protected void dodish() {
        this.preparation();
        this.doing();
        this.carriedDishes();
    }

    /**
     * 备料
     */
    public abstract void preparation();

    /**
     * 做菜
     */
    public abstract void doing();

    /**
     * 上菜
     */
    public abstract void carriedDishes();
}
