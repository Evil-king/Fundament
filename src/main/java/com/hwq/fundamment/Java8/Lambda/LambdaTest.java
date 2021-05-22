package com.hwq.fundamment.Java8.Lambda;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>    void accept(T t)
 * 供给型接口 Supplier<T>    T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T>   boolean test(T t)
 */
public class LambdaTest {

    @Test
    public void Test1(){
        List<String> list = Lists.newArrayList("北京","南京","天津");
        List<String> list1 = filterSting(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        List<String> list2 = filterSting(list,s -> s.contains("京"));
        System.out.println(list2);
    }
    //根据给定的规则，过滤集合中的字符串，此规则有predicate的方法决定
    public List<String> filterSting(List<String> stringList, Predicate<String> predicate){

        List<String> resultList = Lists.newArrayList();

        for(String str : stringList){
            if(predicate.test(str)){
                resultList.add(str);
            }
        }
        return resultList;
    }
}
