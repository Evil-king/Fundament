package com.hwq.fundament.JavaDataStructure.search;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/2/21 0021 11:22
 * @Description: 线性查找，判断数列中是否包含要查找的数值
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 1000, 10, 1000, 89, 1000, 1234};

//        int resultSearch = seqSearch(arr, 1000);
//        if (resultSearch == -1) {
//            System.out.println("没有找到该值");
//        } else {
//            System.out.println("resultSearch=" + resultSearch);
//        }

        List<Integer> resultSearchList = seqSearch2(arr, 1000);
        if (resultSearchList.size() == 0) {
            System.out.println("没有找到该值");
        } else {
            System.out.println("resultSearchList=" + resultSearchList);
        }
    }

    /**
     * 线性查找(不包含重复元素)
     *
     * @param arr       要查找的数组
     * @param findValue 要查的值
     * @return 没有就返回-1
     */
    public static int seqSearch(int arr[], int findValue) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == findValue) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 线性查找(包含重复元素)
     *
     * @param arr       要查找的数组
     * @param findValue 要查的值
     * @return 没有就返回-1
     */
    public static List<Integer> seqSearch2(int arr[], int findValue) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == findValue) {
                list.add(i);
            }
        }
        return list;
    }
}
