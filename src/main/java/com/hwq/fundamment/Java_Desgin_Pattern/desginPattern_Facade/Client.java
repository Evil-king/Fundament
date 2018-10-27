package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_Facade;

/**
 * @author hwq
 * @date 2018/09/23
 */
public class Client {

    public static void main(String[] args) {

        ModenPostOffice modenPostOffice = new ModenPostOffice();

        String context = "Who I am,What I am doing,Where I am";

        String address = "The Seven world";

        modenPostOffice.sendLetter(context,address);
    }
}
