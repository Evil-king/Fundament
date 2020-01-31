package com.hwq.fundamment.JVM;

/**
 * @Auther: Administrator
 * @Date: 2020/1/29 0029 10:26
 * @Description:
 */
public class JavaVMStackSOF {
    private int stackLength =1 ;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
