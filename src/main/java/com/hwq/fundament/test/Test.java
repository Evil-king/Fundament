package com.hwq.fundament.test;



// import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import java.util.*;

/**
 * @author hwq
 * @date 2019/12/07
 * <p>
 * int a=10;中的a在被调用之前就已经创建并初始化，在调用func方法时，他被当做参数传入，所以这个a是实参。
 * 而func(int a)中的a只有在func被调用时它的生命周期才开始，而在func调用结束之后，它也随之被JVM释放掉，，所以这个a是形参
 */
// @Slf4j
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
            List<Integer> list = new ArrayList<Integer>(Arrays.asList(testSix));
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

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 3};
//        int target = 6;
//        int[] ints = twoSum(nums, target);
//        for (int element : ints) {
//            System.out.println(element);
//        }

        int count = 0;
        int[] num = new int[]{1, 3, 5, 6, 3, 7, 9, 0, 3};
        for (int i = 0; i < num.length; i++) {
//            for (int j = 1; j < num.length; j++) {
//                if(num[i] == num[j]){
//                    System.out.println(j);
//                }
//            }
            if(num[i] == 3){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
