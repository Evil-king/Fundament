package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 14:31
 * @Description:
 */
public abstract class Bank {
    protected Account account;
    public Bank(Account account) {
        this.account = account;
    }
    abstract Account openAccount();
}
