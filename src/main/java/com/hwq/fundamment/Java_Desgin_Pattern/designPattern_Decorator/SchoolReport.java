package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Decorator;

/**
 * @author hwq
 * @date 2018/10/08
 */
public abstract class SchoolReport {
    //成绩单的主要展示的就是你的成绩情况
    public abstract void report();
    //成绩单要家长签字，这个是最要命的
    public abstract void sign(String name);
}
