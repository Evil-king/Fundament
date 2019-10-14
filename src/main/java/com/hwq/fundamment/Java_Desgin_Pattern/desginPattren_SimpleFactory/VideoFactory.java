package com.hwq.fundamment.Java_Desgin_Pattern.desginPattren_SimpleFactory;

public class VideoFactory {

    //第一种方式
//    public Video getVideo(String type){
//        if(type.equalsIgnoreCase("java")){
//            return new JavaVideo();
//        }  else if(type.equalsIgnoreCase("Python")){
//            return new PythonVideo();
//        }
//        return null;
//    }

    //第二种方式 做成静态方法
//    public static Video getVideo(String type){
//        if(type.equalsIgnoreCase("java")){
//            return new JavaVideo();
//        }  else if(type.equalsIgnoreCase("Python")){
//            return new PythonVideo();
//        }
//        return null;
//    }

    //第三种 用反射的方法
    public Video getVideo(Class c){
        Video video = null;
        try {
            video = (Video)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
}
