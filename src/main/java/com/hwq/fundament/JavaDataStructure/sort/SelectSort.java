package com.hwq.fundament.JavaDataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2020/3/3 0003 16:44
 * @Description:选择排序
 * 1、选择排序一共有数组大小-1轮排序
 * 2、每一轮排序，又是一个循环，循环的规则：
 * 2-1、先假定当前这个数是最小数
 * 2-2、然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
 * 2-3、当遍历到数组的最后时，就得到本轮最小数和下标
 * 2-4、交换
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};

        //测试冒泡排序的速度O(n^2),给80000个数据，测试
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+dateStr);

        selectSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+dateStr2);
    }
    //选择排序
    public static void selectSort(int[] arr){

        //在推倒的过程中，我们发现了规律，因此，可以使用for循环来解决
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;//假定最小值得下标是0
            int minValue = arr[i];//假定最小值就是数组第一个数
            for (int j = i + 1; j < arr.length; j++) { //从数组第二个数开始，因为第一个数是假定的数用于当做指针从它自己后面开始逐个比较
                if(minValue > arr[j]){ //如果最小数大于它后面一个数，则把minIndex = j,minValue = arr[j]
                    minIndex = j; //重置最小数的下标
                    minValue = arr[j];//重置最小数
                }
            }
            //进行交换，将最小值放在arr[0] = minValue;arr[minIndex] = arr[0];
            if(minIndex != i){ //如果minIndex == i说明就不用交换，不等于的时候才需要交换
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
//            System.out.println("第"+(i+1)+"一轮后~");
//            System.out.println(Arrays.toString(arr));
        }

        /**
        //第一轮
        int minIndex = 0;//假定最小值得下标是0
        int minValue = arr[0];//假定最小值就是数组第一个数
        for (int j = 0 + 1; j < arr.length; j++) { //从数组第二个数开始，因为第一个数是假定的数用于当做指针从它自己后面开始逐个比较
            if(minValue > arr[j]){ //如果最小数大于它后面一个数，则把minIndex = j,minValue = arr[j]
                minIndex = j; //重置最小数的下标
                minValue = arr[j];//重置最小数
            }
        }
        //进行交换，将最小值放在arr[0] = minValue;arr[minIndex] = arr[0];
        if(minIndex != 0){
            arr[minIndex] = arr[0];
            arr[0] = minValue;
        }
        System.out.println("第一轮后~");
        System.out.println(Arrays.toString(arr));


        //第二轮
        minIndex = 1;//假定最小值得下标是0
        minValue = arr[1];//假定最小值就是数组第一个数
        for (int j = 1 + 1; j < arr.length; j++) { //从数组第二个数开始，因为第一个数是假定的数用于当做指针从它自己后面开始逐个比较
            if(minValue > arr[j]){ //如果最小数大于它后面一个数，则把minIndex = j,minValue = arr[j]
                minIndex = j; //重置最小数的下标
                minValue = arr[j];//重置最小数
            }
        }
        //进行交换,
        if(minIndex != 1){
            arr[minIndex] = arr[1];
            arr[1] = minValue;
        }
        System.out.println("第二轮后~");
        System.out.println(Arrays.toString(arr));


        //第三轮
        minIndex = 2;//假定最小值得下标是0
        minValue = arr[2];//假定最小值就是数组第一个数
        for (int j = 2 + 1; j < arr.length; j++) { //从数组第二个数开始，因为第一个数是假定的数用于当做指针从它自己后面开始逐个比较
            if(minValue > arr[j]){ //如果最小数大于它后面一个数，则把minIndex = j,minValue = arr[j]
                minIndex = j; //重置最小数的下标
                minValue = arr[j];//重置最小数
            }
        }
        //进行交换,
        if(minIndex != 2){
            arr[minIndex] = arr[2];
            arr[2] = minValue;
        }
        System.out.println("第三轮后~");
        System.out.println(Arrays.toString(arr));

         **/
    }
}
