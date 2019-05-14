package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Decorator;

/**
 * @author hwq
 * @date 2018/10/08
 */
public class FouthGradeSchoolReport extends SchoolReport {
    //我的成绩单
    public void report() {
        //成绩单的格式是这个样子的
        System.out.println(" 语文 62 数学65 体育 98 自然 63");
        System.out.println(" .......");
        System.out.println(" 家长签名: ");
    }


    //家长签名
    public void sign(String name) {
        System.out.println("家长签名为:" + name);
    }
}
