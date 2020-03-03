package com.hwq.fundamment.JavaDataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Auther: Administrator
 * @Date: 2020/3/3 0003 14:51
 * @Description:冒泡排序 规则：
 * 1、一共进行数组长度-1次排序
 * 2、每一趟排序的次数在逐渐的减少
 * 3、如果我们发现在某趟排序中，没有发生一次交换，可以提前结束排序(优化点)
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};

        //测试冒泡排序的速度O(n^2),给80000个数据，测试
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+dateStr);

        //测试冒泡排序
        bubbleSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+dateStr2);

        /** //第一趟排序，就是将最大的数排在最后
         int temp = 0;//临时变量用于交换的时候用
         for (int j = 0; j < arr.length - 1 - 0; j++) {
         //如果前面的数比后面的数打，则交换
         if (arr[j] > arr[j + 1]) {
         temp = arr[j];
         arr[j] = arr[j + 1];
         arr[j + 1] = temp;
         }
         }
         System.out.println("第一趟排序后的数组");
         System.out.println(Arrays.toString(arr));

         //第二趟排序，就是将第二大的数排在倒数第二位
         for (int j = 0; j < arr.length - 1 - 1; j++) {
         //如果前面的数比后面的数打，则交换
         if (arr[j] > arr[j + 1]) {
         temp = arr[j];
         arr[j] = arr[j + 1];
         arr[j + 1] = temp;
         }
         }
         System.out.println("第二趟排序后的数组");
         System.out.println(Arrays.toString(arr));


         //第三趟排序，就是将第三大的数排在倒数第三位
         for (int j = 0; j < arr.length - 1 - 2; j++) {
         //如果前面的数比后面的数打，则交换
         if (arr[j] > arr[j + 1]) {
         temp = arr[j];
         arr[j] = arr[j + 1];
         arr[j + 1] = temp;
         }
         }
         System.out.println("第三趟排序后的数组");
         System.out.println(Arrays.toString(arr));

         //第四趟排序，就是将第四大的数排在倒数第四位
         for (int j = 0; j < arr.length - 1 - 3; j++) {
         //如果前面的数比后面的数打，则交换
         if (arr[j] > arr[j + 1]) {
         temp = arr[j];
         arr[j] = arr[j + 1];
         arr[j + 1] = temp;
         }
         }
         System.out.println("第四趟排序后的数组");
         System.out.println(Arrays.toString(arr));
         **/
    }

    public static void bubbleSort(int arr[]) {
        //优化：如果我们发现在某趟排序中，没有发生一次交换，可以提前结束排序
        //最终版本 时间复杂度O(n^2)
        int temp = 0;
        boolean flag = false;//标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数打，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if (!flag) { //在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; //重置flag，进行下次判断
            }
        }
    }
}
