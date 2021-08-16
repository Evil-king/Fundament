package com.hwq.fundament.test.Decorator;

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
