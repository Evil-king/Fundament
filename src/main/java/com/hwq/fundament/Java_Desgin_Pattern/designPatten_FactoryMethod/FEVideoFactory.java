package com.hwq.fundament.Java_Desgin_Pattern.designPatten_FactoryMethod;

public class FEVideoFactory implements VideoFactory{
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
