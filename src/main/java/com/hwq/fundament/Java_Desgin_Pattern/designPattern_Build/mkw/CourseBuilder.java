package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.mkw;

/**
 * @author hwq
 * @date 2019/10/20
 */
public abstract class CourseBuilder {

    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();
}
