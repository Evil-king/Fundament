package com.hwq.fundament.colllection;

import java.util.ArrayList;
import java.util.List;

public class ListEqTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(6);
        list1.add(3);
        list1.add(8);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        list2.add(3);
        list2.add(8);
        list2.add(5);
        list2.add(6);

        System.out.println(eq(list1, list2));
        System.out.println(eq(list2, list1));
    }

    private static <T> boolean eq(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        // 标记某个元素是否找到过，防止重复
        boolean matched[] = new boolean[list2.size()];


        outer:for (T t : list1) {
            for (int i = 0; i < list2.size(); i++) {
                // i这个位置没找到过才比较大小
                if (!matched[i] && list2.get(i).equals(t)) {
                    matched[i] = true;
                    continue outer;
                }
            }
            return false;
        }

        return true;
    }
}

