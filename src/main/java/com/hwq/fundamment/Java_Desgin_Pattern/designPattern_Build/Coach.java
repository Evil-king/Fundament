package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Build;

/**
 * @author hwq
 * @date 2019/10/20
 */
public class Coach {
    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCouse(String couseName,String cousePPT,String couseVideo,String couseArticle,String couseQA){
        this.courseBuilder.buildCourseName(couseName);
        this.courseBuilder.buildCoursePPT(cousePPT);
        this.courseBuilder.buildCourseArticle(couseArticle);
        this.courseBuilder.buildCourseQA(couseQA);
        this.courseBuilder.buildCourseVideo(couseVideo);
        return this.courseBuilder.makeCourse();
    }
}
