package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 14:28
 * @Description:
 */
public class SavingAccount implements Account{
    @Override
    public Account openAccount() {
        System.out.println("打开活期账户");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
