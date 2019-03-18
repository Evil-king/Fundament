package com.hwq.fundamment.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

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


        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("1",1) ;
        map.put("2",2) ;
        map.put("3",3) ;
        map.put("4",4) ;
        map.put("5",5) ;
        System.out.println(map.toString());

    }
}
