package com.hwq.fundamment.test;

import lombok.Data;

/**
 * @author hwq
 * @date 2018/10/27
 */
@Data
public class Man<T> extends Person {

    public <T> T toDo(Person person) {
        Man man = new Man();
        man.setAge(person.getAge());
        man.setName(person.getName());
        return (T) man;
    }
}
