package com.hwq.fundamment.DynamicProxy;

public class AppTest {

    public static void main(String[] args) {
//        //真实服务的类
//        HelloService helloService = new HelloServiceImpl();
//
//        //代理对象类
//        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
//        HelloService result = (HelloService) helloServiceProxy.bind(helloService);
//        result.sayHello("张三");


        //真实服务的类
        HelloService helloService = new HelloServiceImpl();

        //代理对象类
        HelloServiceCgLib helloServiceCgLib = new HelloServiceCgLib();
        HelloService result = (HelloService) helloServiceCgLib.getInstance(helloService);
        result.sayHello("张三");
    }

}
