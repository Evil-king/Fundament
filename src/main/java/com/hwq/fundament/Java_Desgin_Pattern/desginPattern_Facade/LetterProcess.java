package com.hwq.fundament.Java_Desgin_Pattern.desginPattern_Facade;

/**
 * @author hwq
 * @date 2018/09/23
 */
public interface LetterProcess {

    //首先要写信的内容
    public void writeContext(String context);

    //其次写信封
    public void fillEnvelope(String address);

    //把信放到信封里
    public void letterInotoEnvelope();

    //然后邮递
    public void sendLetter();
}
