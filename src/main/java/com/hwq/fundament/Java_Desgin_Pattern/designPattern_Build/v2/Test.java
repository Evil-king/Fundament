package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.v2;

/**
 * @author hwq
 * @date 2019/10/20
 */
public class Test {
    public static void main(String[] args) {
        Course couser = new Course.CourseBilder().courseBuildName("JAVA课程").buildCourseArticle("JAVA课程手记").buildCoursePPT("JAVA课程视频").buildCourseVideo(null).buildCourseQA(null).build();

        System.out.println(couser);
    }
}
