package com.hwq.fundamment.Java_Desgin_Pattern.designPatten_FactoryMethod;

public class Client {

    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        VideoFactory videoFactory1 = new PythonVideoFactory();
        VideoFactory videoFactory2 = new FEVideoFactory();
        Video video2 = videoFactory2.getVideo();
        video2.produce();
        Video video1 = videoFactory1.getVideo();
        video1.produce();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
