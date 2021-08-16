package com.hwq.fundament.Think_In_Java.Genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwq
 * @date 2018/10/26
 */
public class GenericVarargs {

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args)
            result.add(item);
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
