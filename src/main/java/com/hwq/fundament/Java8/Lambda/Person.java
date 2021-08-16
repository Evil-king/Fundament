package com.hwq.fundament.Java8.Lambda;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class Person {
    private String name;

    private int age;
}
