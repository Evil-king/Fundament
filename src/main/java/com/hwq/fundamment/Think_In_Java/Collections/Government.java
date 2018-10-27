package com.hwq.fundamment.Think_In_Java.Collections;

import Think_In_Java.Genericity.Generator;


/**
 * @author hwq
 * @date 2018/10/26
 */
public class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basis for a system of " +
            "government").split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}

