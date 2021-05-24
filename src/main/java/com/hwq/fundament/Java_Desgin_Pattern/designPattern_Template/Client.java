package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Template;

/**
 * @author hwq
 * @date 2018/09/23
 */
public class Client {
    public static void main(String[] args) {
        DodishTemplate eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.dodish();

        System.out.println("-----------------------------");

        DodishTemplate bouilli = new Bouilli();
        bouilli.dodish();
    }
}
