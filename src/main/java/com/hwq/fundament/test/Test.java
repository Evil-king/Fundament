package com.hwq.fundament.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.hwq.fundament.tools.IdWorker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author hwq
 * @date 2019/12/07
 * <p>
 * int a=10;中的a在被调用之前就已经创建并初始化，在调用func方法时，他被当做参数传入，所以这个a是实参。
 * 而func(int a)中的a只有在func被调用时它的生命周期才开始，而在func调用结束之后，它也随之被JVM释放掉，，所以这个a是形参
 */
@Slf4j
public class Test {
//    public static void fun(int a) {
//        a = 20;
//        System.out.println(a);
//    }

    public static void valueCrossTest(int age, float weight) {
        System.out.println("传入的age:" + age);
        System.out.println("传入的weight:" + weight);

        age = 33;
        weight = 89.5f;

        System.out.println("方法内重新赋值后的age:" + age);
        System.out.println("方法内重新赋值后的weight:" + weight);

    }

    public static void PersonCrossTest(Person person) {
        System.out.println("传入的person的name：" + person.getName());
        person.setName("我是张小龙");
        System.out.println("方法内重新赋值后的name：" + person.getName());
    }

    public static List<String> pri(String modelCode) {
        List<String> stringList = Lists.newArrayList();
        if ("Test".equals(modelCode)) {
            Integer[] testSix = new Integer[]{1, 2, 3, 4, 5, 6, 49};
            List list = new ArrayList(Arrays.asList(testSix));
            for (int i = 0; i < list.size(); i++) {
                if ((Integer) list.get(i) < 10) {
                    stringList.add("0" + list.get(i) + "");
                } else {
                    stringList.add(list.get(i) + "");
                }
            }
        }
        return stringList;
    }

    /**
     * 判断时间是否在某个时间段内
     *
     * @param s1 时间段开始时间,形如22:30:00
     * @param s2 时间段结束时间,形如06:00:00
     * @return boolean
     */
    public static boolean isInTimeRange(String s1, String s2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String localTime = LocalTime.now().format(formatter);
//        String localTime = "04:03:46";
        int set = Integer.valueOf(localTime.replaceAll(":", ""));
        int begin = Integer.valueOf(s1.replaceAll(":", ""));
        int end = Integer.valueOf(s2.replaceAll(":", ""));
        if (begin >= end) {
            return set <= end || set >= begin;
        } else {
            return set >= begin && set <= end;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        List<Demo> demoList = new ArrayList<>();
//        Demo demo = new Demo();
//        demo.setBettingId(1255406760257962035L);
//        demo.setBettingName("单");
//        demo.setGroupName("双面");
//        demo.setMethodName("冠军");
//
//        Demo demo1 = new Demo();
//        demo1.setBettingId(1255406760257962036L);
//        demo1.setBettingName("双");
//        demo1.setGroupName("双面");
//        demo1.setMethodName("冠军");
//
//        demoList.add(demo);
//        demoList.add(demo1);
//        int[] arr = {4};
//        operatorData(arr, demoList);

//        List<String> originalData = Lists.newArrayList("1291631760086216707&双面&双面&小","1291631760086216708&双面&双面&单");
//
//        List<String> dbData = Lists.newArrayList("1291631760086216706&双面&双面&大","1291631760086216707&双面&双面&小","1291631760086216708&双面&双面&单","1291631760086216709&双面&双面&双");
//
//        for (int i = 0; i < dbData.size(); i++) {
//            for (int j = 0; j < originalData.size(); j++) {
//                if(dbData.get(i).equals(originalData.get(j))){
//                    dbData.remove(i);
//                }
//            }
//        }
//        log.info("originalData={}", JSON.toJSON(originalData));
//        log.info("dbData={}", JSON.toJSON(dbData));

//        Object obj = new Object();
//
//        Thread thread1 = new Thread(() -> {
//            synchronized (obj) {
//                try {
//                    obj.wait();
//                    System.out.println("Thread 1");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread1.start();
//        Thread.sleep(1000);
//
//        Thread thread2 = new Thread(() -> {
//            synchronized (obj) {
//                obj.notify();
//                System.out.println("Thread 2");
//
//            }
//        });
//        thread2.start();

        for (int i = 0; i < 2; i++) {
            System.out.println(IdWorker.getId());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static
    class Demo {
        private long bettingId;
        private String groupName;
        private String methodName;
        private String bettingName;
    }

    public static void operatorData(int[] number, List<Demo> demoList) {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < demoList.size(); i++) {
            Demo demo = demoList.get(i);
            if ("双面".equals(demo.getGroupName())) {
                if ("冠军".equals(demo.getMethodName())) {
                    if (number[0] % 2 == 0 && "双".equals(demo.getBettingName())) {
                        for (int j = 0; j < demoList.size(); j++) {
                            if ("单".equals(demoList.get(j).getBettingName())) {
                                list.add(demo.getBettingId() + "&" + demo.getGroupName() + "&" + demo.getMethodName() + "&" + demoList.get(j).getBettingName());
                            }
                        }
                    } else if (number[0] % 2 != 0 && "单".equals(demo.getBettingName())) {
                        for (int j = 0; j < demoList.size(); j++) {
                            if ("双".equals(demoList.get(j).getBettingName())) {
                                list.add(demo.getBettingId() + "&" + demo.getGroupName() + "&" + demo.getMethodName() + "&" + demoList.get(j).getBettingName());
                            }
                        }
                    }
                }
            }
            log.info("list={}", list);
        }
    }
}
