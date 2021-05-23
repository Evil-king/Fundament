package com.hwq.fundamment.Java8.ReactiveStreams;

import java.util.ArrayList;
import java.util.List;

public class EmpHelper {
    public static List<Employee> getEmps() {

        Employee e1 = new Employee(1, "Pankaj",20,19000.00);
        Employee e2 = new Employee(2, "David",23,1000.00);
        Employee e3 = new Employee(3, "Lisa",28,89999);
        Employee e4 = new Employee(4, "Ram",40,9222);
        Employee e5 = new Employee(5, "Anupam",31,4333);

        List<Employee> emps = new ArrayList<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
        emps.add(e4);
        emps.add(e5);

        return emps;
    }
}
