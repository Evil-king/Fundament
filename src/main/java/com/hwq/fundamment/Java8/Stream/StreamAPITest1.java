package com.hwq.fundamment.Java8.Stream;

import com.hwq.fundamment.Java8.ReactiveStreams.EmpHelper;
import com.hwq.fundamment.Java8.ReactiveStreams.Employee;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 厕所Stream的中间操作
 */
public class StreamAPITest1 {
    //1、筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmpHelper.getEmps();
        //filter(Predicate p)-----接收 Lambda 从流中排除某些元素
        list.stream().filter(employee -> employee.getSalary()> 1000).forEach(System.out::println);
        System.out.println();
        //limit(n)----截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        //skip(n)----跳过元素，返回一个扔掉了前n哥元素的流，若流中元素不足n哥，则返回一个空流
        System.out.println();
        list.stream().skip(10).forEach(System.out::println);
        //distinct()----筛选,通过流所生成元素的hashCode()和equals()去除重复元素
        System.out.println();
        list.add(new Employee(6,"Jack",9,9002));
        list.add(new Employee(6,"Jack",9,9002));

        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        //map(Function f)----接收一个函数作为参数，将元素转换为其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        ArrayList<String> strings = Lists.newArrayList("aa", "nn", "cc", "dd");
        strings.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        System.out.println();

        //获取员工姓名长度大于3的员工的姓名。
        List<Employee> list = EmpHelper.getEmps();
        list.stream().map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);

        //flatmap(Function f)---接收一个函数作为参数，将流中的每个值换成另一个流，然后把所有流合连成一个流。(更适合集合中嵌套集合的场景)
    }

    //排序
    @Test
    public void test3(){
        //sorted()——————自然排序
        ArrayList<Integer> integers = Lists.newArrayList(1232, 32, 44, 565, 767, 232);
        integers.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)-----定制排序
        List<Employee> list = EmpHelper.getEmps();
        list.stream().sorted((e1,e2) ->{
            return Integer.compare(e1.getId(),e2.getId());
        }).forEach(System.out::println);
    }
}
