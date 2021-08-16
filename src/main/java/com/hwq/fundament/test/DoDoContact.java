package com.hwq.fundament.test;

import lombok.Builder;
import lombok.ToString;

/**
 * builder建造模式
 */
@Builder
@ToString
public class DoDoContact {
    private final int  age;
    private final int  safeID;
    private final String name;
    private final String address;

    public static void main(String[] args) {
        DoDoContact dodo = DoDoContact.builder().safeID(10).name("fox").age(10).address("天堂").build();
        System.out.println(dodo);

    }
}
