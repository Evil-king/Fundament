package com.hwq.fundamment.JavaDataStructure.sort;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2020/3/4 0004 12:09
 * @Description: 1、选择排序一共有数组大小-1轮排序
 * 2、每一轮排序，又是一个循环，循环的规则：
 * 2-1、先假定当前这个数是最小数
 * 2-2、然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
 * 2-3、当遍历到数组的最后时，就得到本轮最小数和下标
 * 2-4、交换
 */
public class SelectSortTest {
    public static void main(String[] args) {
        int arr[] = {9, 3, -1, 20, 0};
        System.out.println(Arrays.toString(arr));
        selectSortTest(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSortTest(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//假定当前下标
            int minVal = arr[i];//假定当前第一个数
            for (int j = i + 1; j < arr.length; j++) {
                if (minVal > arr[j]) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            //进行交换，将最小值放在arr[0] = minValue;arr[minIndex] = arr[0];
            if(minIndex != i){ //如果minIndex == i说明就不用交换，不等于的时候才需要交换
                arr[minIndex] = arr[i];
                arr[i] = minVal;
            }
        }




        /**
        //第一轮
        int minIndex = 0;//假定当前下标
        int minVal = arr[0];//假定当前第一个数
        for (int j = 0 + 1; j < arr.length; j++) {
            if (minVal > arr[j]) {
                minIndex = j;
                minVal = arr[j];
            }
        }
        //进行交换，将最小值放在arr[0] = minValue;arr[minIndex] = arr[0];
         if(minIndex != 0){
         arr[minIndex] = arr[0];
         arr[0] = minVal;
         }
        System.out.println("第一轮后~");
        System.out.println(Arrays.toString(arr));

        //第二轮
        minIndex = 1;//假定当前下标
        minVal = arr[1];//假定当前第一个数
        for (int j = 1 + 1; j < arr.length; j++) {
            if (minVal > arr[j]) {
                minIndex = j;
                minVal = arr[j];
            }
        }
        //进行交换，将最小值放在arr[0] = minValue;arr[minIndex] = arr[0];
         if(minIndex != 1){
             arr[minIndex] = arr[1];
             arr[1] = minVal;
         }
        System.out.println("第二轮后~");
        System.out.println(Arrays.toString(arr));

        //第3轮
        minIndex = 2;//假定当前下标
        minVal = arr[2];//假定当前第一个数
        for (int j = 2 + 1; j < arr.length; j++) {
            if (minVal > arr[j]) {
                minIndex = j;
                minVal = arr[j];
            }
        }
        //进行交换，将最小值放在arr[0] = minValue;arr[minIndex] = arr[0];
         if(minIndex != 2){
             arr[minIndex] = arr[2];
             arr[2] = minVal;
         }
        System.out.println("第3轮后~");
        System.out.println(Arrays.toString(arr));


        //第4轮
        minIndex = 3;//假定当前下标
        minVal = arr[3];//假定当前第一个数
        for (int j = 3 + 1; j < arr.length; j++) {
            if (minVal > arr[j]) {
                minIndex = j;
                minVal = arr[j];
            }
        }
        //进行交换，将最小值放在arr[0] = minValue;arr[minIndex] = arr[0];
         if(minIndex != 3){
             arr[minIndex] = arr[3];
             arr[3] = minVal;
         }
        System.out.println("第4轮后~");
        System.out.println(Arrays.toString(arr));
        **/
    }
}
