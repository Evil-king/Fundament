package com.hwq.fundament.Java_Desgin_Pattern.designPatten_FactoryMethod;

public class JavaVideoFactory implements VideoFactory{
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
