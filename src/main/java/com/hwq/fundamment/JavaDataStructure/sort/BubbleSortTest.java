package com.hwq.fundamment.JavaDataStructure.sort;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2020/3/4 0004 11:44
 * @Description:
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int arr[] = {9, 3, -1, 20, 0};
        System.out.println(Arrays.toString(arr));
        bubbleSortTest(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSortTest(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(flag){
                flag = false;
            } else {
                break;
            }
        }


        /**
        //第一轮
        int temp = 0;
        for (int j = 0; j < arr.length - 1 - 0; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一轮~~~");
        System.out.println(Arrays.toString(arr));

        //第二轮
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二轮~~~");
        System.out.println(Arrays.toString(arr));

        //第三轮
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三轮~~~");
        System.out.println(Arrays.toString(arr));

        //第四轮
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四轮~~~");
        System.out.println(Arrays.toString(arr));
         **/
    }
}
