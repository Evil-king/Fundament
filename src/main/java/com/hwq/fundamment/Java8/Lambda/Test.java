package com.hwq.fundamment.Java8.Lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class Test {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        //filter(T -> boolean)
        List<Person> personList = list.stream().filter(person -> person.getAge() == 20).collect(toList());
        log.info("personList={}",personList);
        //sorted() / sorted((T, T) -> int) 如果流中的元素的类实现了 Comparable 接口，即有自己的排序规则，那么可以直接调用 sorted() 方法对元素进行排序，
        // 如 Stream<Integer> 反之, 需要调用 sorted((T, T) -> int) 实现 Comparator 接口
        Stream<Person> sorted = list.stream().sorted(Comparator.comparingInt(Person::getAge));
        log.info("sorted={}",sorted);
        //limit(long n) 返回前 n 个元素
        List<Person> collect = list.stream().limit(2).collect(toList());
        log.info("collect={}",collect);
        //skip(long n) 去除前 n 个元素
        List<Person> collect1 = list.stream().skip(2).collect(toList());
        log.info("collect1={}",collect1);
        // map(T -> R)  将流中的每一个元素 T 映射为 R（类似类型转换）
        List<String> newList = list.stream().map(Person::getName).collect(toList());
        log.info("newList={}",newList);
        //flatMap(T -> Stream<R>) 将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
        List<String> listOne = new ArrayList<>();
        listOne.add("aaa bbb ccc");
        listOne.add("ddd eee fff");
        listOne.add("ggg hhh iii");
        listOne = listOne.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(toList());
        log.info("listOne={}",listOne);
    }
}
