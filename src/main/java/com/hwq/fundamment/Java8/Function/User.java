package com.hwq.fundamment.Java8.Function;


import java.util.function.Supplier;

/**
 * @author hwq
 * @date 2018/10/18
 */
public class User {

    private String name;

    private int age;

    public User() {

    }

    public static User create(Supplier<User> supplier) {
        return supplier.get();
    }

    public static void updateUsername(User user) {
        user.setName(user.getName() + "update");
    }

    public void updateAge() {
        this.setAge(this.getAge() + 10);
    }

    public void changeAge(User user) {
        user.setAge(user.getAge() + 10);
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
