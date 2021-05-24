package com.hwq.fundament.Java_Desgin_Pattern.designPatten_FactoryMethod;

public class PythonVideoFactory implements VideoFactory{
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
