package com.hwq.fundamment.Java_Desgin_Pattern.desginPattren_SimpleFactory;

public class Client {

    public static void main(String[] args) {
//        VideoFactory videoFactory = new VideoFactory();
//        Video  video = videoFactory.getVideo("java");
//        if(video == null){
//            return;
//        }
//        video.produce();


//        Video  video = VideoFactory.getVideo("java");
//        if(video == null){
//            return;
//        }
//        video.produce();

        VideoFactory videoFactory = new VideoFactory();
        Video video =videoFactory.getVideo(JavaVideo.class);
        video.produce();
    }
}
