package com.hwq.fundamment.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("000");
//        list.add("111");

//          List<String> list = new LinkedList<>();
//        list.add("000");
//        list.add("111");

//        List<Integer> list = new CopyOnWriteArrayList<Integer>();
//        list.add(1);
//        list.add(2);

//        Map<String,String> map = new HashMap<String,String>();
//        map.put("name","fox");


//        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
//        map.put("1", 1);
//        map.put("2", 2);
//        map.put("3", 3);
//        map.put("4", 4);
//        map.put("5", 5);
//        System.out.println(map.toString());

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        //截取所有能被2整除得数据
//        List<Integer> collect = integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        List<Integer> collect = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("collect = " + collect);

        List<Integer> integers = Arrays.asList(5, 8, 2, 6, 41, 11);
        List<Integer> sorted = integers.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted = " + sorted);
    }
}
