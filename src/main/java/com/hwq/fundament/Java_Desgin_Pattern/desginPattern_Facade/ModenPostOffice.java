package com.hwq.fundament.Java_Desgin_Pattern.desginPattern_Facade;


/**
 * @author hwq
 * @date 2018/09/23
 * 可扩展性很强，需要新加入任何业务都只在这个方法中加入即可
 */
public class ModenPostOffice {

    private LetterProcess letterProcess = new LetterProcessImpl();

    //把写信的四步一体化了,并且提供为接口给外部
    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);

        letterProcess.fillEnvelope(address);

        letterProcess.letterInotoEnvelope();

        letterProcess.sendLetter();
    }

}
