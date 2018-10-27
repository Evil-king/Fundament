package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Decorator;


/**
 * @author hwq
 * @date 2018/10/08
 */
public class Father {
    public static void main(String[] args) {
        //成绩单拿过来
        SchoolReport sr = new FouthGradeSchoolReport(); //看成绩单

        sr = new HighScoreDecorator(sr);

        sr = new SortDecorator(sr);
        //签名?休想!
        sr.report();

        sr.sign("张三");
    }
}
