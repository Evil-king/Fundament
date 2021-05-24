package com.hwq.fundament.Think_In_Java.Collections;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author hwq
 * @date 2018/10/26
 */
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(new Government(), 15));
        // Using the convenience method:
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
