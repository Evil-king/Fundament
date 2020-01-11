package com.hwq.fundamment.DefineClassLoader;

/**
 * @author hwq
 * @date 2020/01/11
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
