package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Build.mkw;

/**
 * @author hwq
 * @date 2019/10/20
 */
public class Client {
    public static void main(String[] args) {
        CourseActualBuilder courseActualBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseActualBuilder);

        Course course = coach.makeCouse(
                "JAVA设计模式","JAVA设计模式PPT","JAVA设计模式视频","JAVA设计模式收集","JAVA设计模式问答"
        );
        System.out.println(course);
    }
}
