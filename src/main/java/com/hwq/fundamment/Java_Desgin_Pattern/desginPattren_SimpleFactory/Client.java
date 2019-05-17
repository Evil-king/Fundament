package com.hwq.fundamment.Java_Desgin_Pattern.desginPattren_SimpleFactory;

public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(2);
        // do something with the product
    }
}
