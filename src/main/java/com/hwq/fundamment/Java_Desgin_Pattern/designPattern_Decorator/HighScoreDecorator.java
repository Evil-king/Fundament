package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Decorator;

/**
 * @author hwq
 * @date 2018/10/08
 */
public class HighScoreDecorator extends Decorator {

    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    public void reportHighScore() {
        System.out.println("语文最高分70，数学最高分90");
    }

    public void report() {
        this.reportHighScore();
        super.report();
    }
}
