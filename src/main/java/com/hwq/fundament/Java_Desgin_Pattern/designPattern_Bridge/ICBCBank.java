package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 14:35
 * @Description:
 */
public class ICBCBank extends Bank{
    public ICBCBank(Account account) {
        super(account);
    }
    @Override
    Account openAccount() {
        System.out.println("打开工商银行账户");
        account.openAccount();
        return account;
    }
}
