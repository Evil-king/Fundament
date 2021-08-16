package com.hwq.fundament.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;

public class Client {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.makeArticle().produce();
        courseFactory.makeVideo().produce();

        CourseFactory courseFactory1 = new PythonCourseFactory();
        courseFactory1.makeArticle().produce();
        courseFactory1.makeVideo().produce();
    }
}
