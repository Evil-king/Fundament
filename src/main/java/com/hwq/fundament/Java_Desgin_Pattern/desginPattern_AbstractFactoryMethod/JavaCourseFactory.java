package com.hwq.fundament.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;

public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video makeVideo() {
        return new JavaVideo();
    }

    @Override
    public Article makeArticle() {
        return new JavaArticle();
    }
}
