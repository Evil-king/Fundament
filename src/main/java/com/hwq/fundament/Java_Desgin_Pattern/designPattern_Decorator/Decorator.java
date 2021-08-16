package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Decorator;


/**
 * @author hwq
 * @date 2018/10/08
 */
public class Decorator extends SchoolReport {

    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    @Override
    public void report() {
        this.schoolReport = schoolReport;
    }

    @Override
    public void sign(String name) {
        this.schoolReport.sign(name);
    }
}
