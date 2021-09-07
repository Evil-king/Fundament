package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Bridge.mkw;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 14:46
 * @Description:
 */
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
