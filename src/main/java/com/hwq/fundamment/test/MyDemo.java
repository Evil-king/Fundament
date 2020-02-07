package com.hwq.fundamment.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyDemo {
    public void test(Demo demo){
        System.out.println("test method");
    }

    public static void main(String[] args) {
        MyDemo myDemo= new MyDemo();

        //处理日期
        LocalDate now = LocalDate.now();
//        System.out.println(now);
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
//        System.out.printf("year = %d, month = %d, day = %d", year, monthValue, dayOfMonth);


//        LocalDate now = LocalDate.now();
//        LocalDate date = LocalDate.of(2018, 06, 20);
//        if (date.equals(now)) {
//            System.out.println("同一天");
//        } else {
//            System.out.println("不是同一天");
//        }

        //处理时间
//        LocalTime localTime = LocalTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(localTime.atDate(LocalDate.parse(LocalDate.now().format(formatter))));
//        LocalTime localTime1 = localTime.plusHours(25);//增加336小时
//        System.out.println(localTime1);

        LocalDate localDate = LocalDate.of(2019,1,7);
        LocalTime localTime = LocalTime.now();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDate.atTime(localTime).format(f));


        //一周后的时间
//        LocalDate now = LocalDate.now();
//        LocalDate plusDate = now.plus(2, ChronoUnit.WEEKS);
//        System.out.println(now);
//        System.out.println(plusDate);


//        myDemo.test(new Demo() {
//            @Override
//            public void demoMethod() {
//                System.out.println("具体实现");
//            }
//        });
    }
}
