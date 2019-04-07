package com.hwq.fundamment.test.Decorator;

import com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Decorator.Decorator;

/**
 * @author hwq
 * @date 2019/04/05
 */
public class Main {

    public static void main(String[] args) {
        ComponentSerevice componentSerevice = new ConcreteComponentService();
        DecoratorService decoratorService = new ConcreteDecoratorService(componentSerevice);
        String msg = decoratorService.login("fox", "123");
        System.out.println(msg);
    }
}
