package com.hwq.fundamment.JavaDataStructure.sort;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2020/3/4 0004 10:25
 * @Description:插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 12, 1};
        insertSort(arr);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    //插入排序

    /**
     * 插入排序的基本思想是：
     * 把n个待排序的元素看成一个有序表和一个无序表，开始时有序表只包含一个元素，
     * 无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排序码依次与
     * 有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //没有找到位置，后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //找到位置
            arr[insertIndex + 1] = insertVal;
        }


        /**
         //第一轮
         //定义待插入的数，从数组的第二个数开始，因为第一个数是假定有序的数
         int insertValue = arr[1];
         //待插入的下标 为什么是1-1 因为是待插入数的前面一个数
         int insertIndex = 1 - 1;
         //给insertValue 找到插入的位置
         //说明
         //1、insertIndex >= 0 保证在给insertValue找插入位置 不越界
         //2、insertValue < arr[insertIndex] 待插入的数，还没有找到插入位置
         //3、就需要将arr[insertIndex]后移
         while (insertIndex >= 0 && insertValue < arr[insertIndex]){
         arr[insertIndex+1] = arr[insertIndex];//就需要将arr[insertIndex]后移
         insertIndex--;
         }
         //当退出while循环时，说明插入的位置找到，insertIndex+1
         arr[insertIndex + 1]  = insertValue;
         System.out.println("第一轮过后~~~");
         System.out.println(Arrays.toString(arr));

         //第2轮
         //定义待插入的数，从数组的第二个数开始，因为第一个数是假定有序的数
         insertValue = arr[2];
         //待插入的下标 为什么是1-1 因为是待插入数的前面一个数
         insertIndex = 2 - 1;
         //给insertValue 找到插入的位置
         //说明
         //1、insertIndex >= 0 保证在给insertValue找插入位置 不越界
         //2、insertValue < arr[insertIndex] 待插入的数，还没有找到插入位置
         //3、就需要将arr[insertIndex]后移
         while (insertIndex >= 0 && insertValue < arr[insertIndex]){
         arr[insertIndex+1] = arr[insertIndex];//就需要将arr[insertIndex]后移
         insertIndex--;
         }
         //当退出while循环时，说明插入的位置找到，insertIndex+1
         arr[insertIndex + 1]  = insertValue;
         System.out.println("第2轮过后~~~");
         System.out.println(Arrays.toString(arr));

         //第3轮
         //定义待插入的数，从数组的第二个数开始，因为第一个数是假定有序的数
         insertValue = arr[3];
         //待插入的下标 为什么是1-1 因为是待插入数的前面一个数
         insertIndex = 3 - 1;
         //给insertValue 找到插入的位置
         //说明
         //1、insertIndex >= 0 保证在给insertValue找插入位置 不越界
         //2、insertValue < arr[insertIndex] 待插入的数，还没有找到插入位置
         //3、就需要将arr[insertIndex]后移
         while (insertIndex >= 0 && insertValue < arr[insertIndex]){
         arr[insertIndex+1] = arr[insertIndex];//就需要将arr[insertIndex]后移
         insertIndex--;
         }
         //当退出while循环时，说明插入的位置找到，insertIndex+1
         arr[insertIndex + 1]  = insertValue;
         System.out.println("第3轮过后~~~");
         System.out.println(Arrays.toString(arr));
         **/
    }
}
