//package com.hwq.fundamment.DynamicProxy;
//
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.invoke.MethodHandleInfo;
//import java.lang.reflect.Method;
//
///**
// * CgLib代理
// */
//public class HelloServiceCgLib implements MethodInterceptor {
//
//    private Object target;//业务类对象，供代理方法中进行真正的业务方法调用
//
//
//    //相当于JDK动态代理中的绑定
//    public Object getInstance(Object target) {
//        this.target = target;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(this.target.getClass());
//        //回调方法
//        enhancer.setCallback(this);
//        //创建代理对象
//        return enhancer.create();
//    }
//
//    @Override
//    //回调方法
//    public Object intercept(Object objects, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        System.out.println("------------------------------我是CgLib代理----------------------");
//        //反射方法调用前
//        Object result = methodProxy.invokeSuper(objects, args);
//        //反射方法调用后
//        return result;
//    }
//}
