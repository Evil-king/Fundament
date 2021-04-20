package com.hwq.fundamment.JavaDataStructure.sort;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2020/3/4 0004 14:26
 * @Description:希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //根据前面的逐步分析，使用循环处理
        //希尔排序时，对有序序列在插入时采用交换法
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共gap组，每组有两个元素) j-=gap是表示每次移动gap个步长
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮后=" + Arrays.toString(arr));
        }

        /**
         //第1轮
         //因为第1轮排序，是将10个数据分成5组
         for (int i = 5; i < arr.length; i++) {
         //遍历各组中所有的元素(共5组，每组有两个元素) j-=5是表示每次移动5个步长(第0个元素和第5个元素比较)
         for (int j = i - 5; j >= 0; j -= 5) {
         if (arr[j] > arr[j + 5]) {
         temp = arr[j];
         arr[j] = arr[j + 5];
         arr[j + 5] = temp;
         }
         }
         }
         System.out.println("希尔排序第1轮后=" + Arrays.toString(arr));

         //第2轮
         //因为第2轮排序，是将10个数据分成5/2 = 2组
         for (int i = 2; i < arr.length; i++) {
         //遍历各组中所有的元素(共2组，每组有两个元素) j-=2是表示每次移动2个步长
         for (int j = i - 2; j >= 0; j -= 2) {
         if (arr[j] > arr[j + 2]) {
         temp = arr[j];
         arr[j] = arr[j + 2];
         arr[j + 2] = temp;
         }
         }
         }
         System.out.println("希尔排序第2轮后=" + Arrays.toString(arr));


         //第3轮
         //因为第3轮排序，是将10个数据分成2/2 = 1组
         for (int i = 1; i < arr.length; i++) {
         //遍历各组中所有的元素(共1组，每组有两个元素) j-=1是表示每次移动1个步长
         for (int j = i - 1; j >= 0; j -= 1) {
         if (arr[j] > arr[j + 1]) {
         temp = arr[j];
         arr[j] = arr[j + 1];
         arr[j + 1] = temp;
         }
         }
         }
         System.out.println("希尔排序第3轮后=" + Arrays.toString(arr));
         **/
    }
    //对交换式的希尔排序进行优化->移位法


}
