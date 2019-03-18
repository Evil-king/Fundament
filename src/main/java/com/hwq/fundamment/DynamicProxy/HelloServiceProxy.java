package com.hwq.fundamment.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler {

    //真是服务对象
    private Object target;

    //绑定委托对象并返回代理类
    public Object bind(Object target){
      this.target = target;
      return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------------------我是JDK代理----------------------");
        //反射方法前
        System.out.println("我准备说hello");
        Object result = method.invoke(target, args);
        //反射方法后
        System.out.println("我已经说过hello");
        return result;
    }
}
