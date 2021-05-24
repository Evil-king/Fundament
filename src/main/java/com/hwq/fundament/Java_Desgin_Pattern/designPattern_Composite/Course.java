package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Composite;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 15:26
 * @Description: 课程类
 */
public class Course extends CatalogComponent{

    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name = name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price = price;
    }

    @Override
    public void print() {
        System.out.println("Course Name:"+name+" Price:"+price);
    }
}
