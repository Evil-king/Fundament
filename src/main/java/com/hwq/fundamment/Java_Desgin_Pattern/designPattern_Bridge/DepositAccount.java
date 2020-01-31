package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 14:28
 * @Description:
 */
public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开定期账户");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
