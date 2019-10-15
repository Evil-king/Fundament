package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;

public class PythonCourseFactory implements CourseFactory{
    @Override
    public Video makeVideo() {
        return new PythonVideo();
    }

    @Override
    public Article makeArticle() {
        return new PythonArticle();
    }
}
