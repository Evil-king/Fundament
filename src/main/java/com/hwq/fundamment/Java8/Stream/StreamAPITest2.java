package com.hwq.fundamment.Java8.Stream;

import com.hwq.fundamment.Java8.ReactiveStreams.EmpHelper;
import com.hwq.fundamment.Java8.ReactiveStreams.Employee;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 测试Stream的终止操作
 */
public class StreamAPITest2 {
    //1、匹配与查找
    @Test
    public void test1(){
        List<Employee> list = EmpHelper.getEmps();
        //allMatch(Predicate p)--检查是否匹配所有元素
        boolean allMatch = list.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(allMatch);

        //anyMatch(Predicate p)--检查是否至少匹配一个元素
        boolean anyMatch = list.stream().anyMatch(employee -> employee.getSalary() > 5000);
        System.out.println(allMatch);

        //noneMatch(Predicate p)--检查是否没有匹配的元素
        boolean noneMatch = list.stream().noneMatch(employee -> employee.getSalary() > 10000);
        System.out.println(noneMatch);

        //findFirst--返回第一个元素
        Employee employee = list.stream().findFirst().get();
        System.out.println(employee);

        //findAny--返回当前流中的任意元素
        Optional<Employee> e = list.stream().findAny();
        System.out.println(e);

        //count--返回流中的总个数
        long count = list.stream().count();
        System.out.println(count);


        //max(Comparator c)--返回流中最大值
        Optional<Double> max = list.stream().map(employee1 -> employee1.getSalary()).max(Double::compareTo);
        System.out.println(max);

        //min(Comparator c)--返回流中最小值
        Optional<Integer> min = list.stream().map(employee1 -> employee1.getAge()).min(Integer::compareTo);
        System.out.println(min);

        //forEach(Consumer c)--内部迭代
        list.stream().forEach(System.out::println);
    }

    //2、规约
    @Test
    public void test2(){
        //reduce(T identity,BinaryOperator)---可以将流中元素反复结合起来，得到一个值。返回一个T
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //reduce(BinaryOperator)--可以将流反复结合起来得到一个新值
        List<Employee> employees = EmpHelper.getEmps();
//        Optional<Double> reduce1 = employees.stream().map(employee -> employee.getSalary()).reduce(Double::sum);
        Optional<Double> reduce1 = employees.stream().map(employee -> employee.getSalary()).reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce1);
    }

    //3、收集
    @Test
    public void test3(){
        //collect(Collector c)--将流转换为其他形式。将员工工资大于1000的返回一个list或set
        List<Employee> list = EmpHelper.getEmps();
        Set<Employee> collect = list.stream().filter(employee -> employee.getSalary() > 2000).collect(Collectors.toSet());
        for (Employee employee: collect){
            System.out.println(employee);
        }
    }
}
