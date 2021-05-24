package com.hwq.fundament.JavaDataStructure.search;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/2/21 0021 10:26
 * @Description: 二分查找法，使用二分查找法的前提是 数组一定要是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000,1000, 1234};

//        int resultIndex = binarySearch(arr, 0, arr.length, 1000);
//        System.out.println("resultIndex=" + resultIndex);

        List<Integer> integerList = binarySearch2(arr, 0, arr.length-1, 1);
        System.out.println("integerList=" + integerList);
    }

    /**
     * 二分查找算法
     *
     * @param arr       查找的数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findValue 要查找的值
     * @return 如果找到就返回下标，如果没有则返回-1
     */
    public static int binarySearch(int arr[], int left, int right, int findValue) {
        //首先确定该数组的中间下标
        int mid = (left + right) / 2;
        //取到中间的值
        int midValue = arr[mid];

        //当left > right的时候说明找不到，则直接结束
        if(left > right){
            return -1;
        }
        if (findValue > midValue) { // 说明要向右边递归
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) { //说明要向左边递归
            return binarySearch(arr, left, mid - 1, findValue);
        } else { //说明findValue == midValue
                return mid;
        }
    }

    /**
     * {1, 8, 10, 89, 1000, 1234}当一个有序数组中，有多个相同的数值时，如何将所有的数值都找到，比如 1000
     *
     * 思路：
     * 1、在找到mid 索引值，不要马上返回
     * 2、向mid 索引值的左边扫描，将所有满足1000的元素下标，加入到集合中去
     * 3、向mid 索引值的右边扫描，将所有满足1000的元素下标，加入到集合中去
     * 4、将集合返回
     */

    /**
     * 二分查找算法（有相同的元素一起返回）
     *
     * @param arr       查找的数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findValue 要查找的值
     * @return 如果找到就返回下标，如果没有则返回-1
     */
    public static List<Integer> binarySearch2(int arr[], int left, int right, int findValue) {
        //首先确定该数组的中间下标
        int mid = (left + right) / 2;
        //取到中间的值
        int midValue = arr[mid];

        //当left > right的时候说明找不到，则直接结束
        if(left > right){
            return new ArrayList<Integer>();
        }
        if (findValue > midValue) { // 说明要向右边递归
            return binarySearch2(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) { //说明要向左边递归
            return binarySearch2(arr, left, mid - 1, findValue);
        } else { //说明findValue == midValue
            /**思路：
                * 1、在找到mid 索引值，不要马上返回
                * 2、向mid 索引值的左边扫描，将所有满足1000的元素下标，加入到集合中去
                * 3、向mid 索引值的右边扫描，将所有满足1000的元素下标，加入到集合中去
                * 4、将集合返回
             */
            List<Integer> resultIndexList = Lists.newArrayList();
            //向mid 索引值的左边扫描，将所有满足1000的元素下标，加入到集合中去
            int temp = mid -1;
            while (true){
                if(temp < 0 || arr[temp] != findValue){
                    break;
                }
                //否则，就将temp加入到集合中去
                resultIndexList.add(temp);
                temp =  temp - 1;//左移
            }
            resultIndexList.add(mid);//把中间的也加入到集合中
            //向mid 索引值的右边扫描，将所有满足1000的元素下标，加入到集合中去
            temp = mid + 1;
            while (true){
                if(temp > arr.length-1 || arr[temp] != findValue){
                    break;
                }
                //否则，就将temp加入到集合中去
                resultIndexList.add(temp);
                temp =  temp + 1;//右移
            }
            return resultIndexList;
        }
    }

}
