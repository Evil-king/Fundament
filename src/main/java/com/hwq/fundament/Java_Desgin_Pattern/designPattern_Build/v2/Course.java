package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.v2;

import lombok.ToString;

/**
 * @author hwq
 * @date 2019/10/20
 */
@ToString
public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA;

    public Course(CourseBilder couserBilder){
        this.courseName = couserBilder.courseName;
        this.coursePPT = couserBilder.coursePPT;
        this.courseVideo = couserBilder.courseVideo;
        this.courseArticle = couserBilder.courseArticle;
        this.courseQA = couserBilder.courseQA;
    }

    public static class CourseBilder{
        private String courseName;
        private String coursePPT;
        private String courseVideo;
        private String courseArticle;
        private String courseQA;

        public CourseBilder courseBuildName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public CourseBilder buildCoursePPT(String coursePPT) {
            this.coursePPT = coursePPT;
            return this;
        }

        public CourseBilder buildCourseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }

        public CourseBilder buildCourseArticle(String courseArticle) {
            this.courseArticle = courseArticle;
            return this;
        }

        public CourseBilder buildCourseQA(String courseQA) {
            this.courseQA = courseQA;
            return this;
        }

        public Course build(){
            return new Course(this);
        }
    }
}
