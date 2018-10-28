package com.hwq.fundamment.Think_In_Java.Collections;


import com.hwq.fundamment.Think_In_Java.Genericity.Generator;

import java.util.ArrayList;

/**
 * @author hwq
 * @date 2018/10/26
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for(int i = 0; i < quantity; i++)
            add(gen.next());
    }
    // A generic convenience method:
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}
